package com.desafio.bipa.feature.node_list.viewModel

import app.cash.turbine.test
import com.desafio.bipa.core.data.repository.LightningRepository
import com.desafio.bipa.core.domain.use_case.GetNodeListUseCase
import com.desafio.bipa.core.model.Node
import com.desafio.bipa.core.testing.repository.TestLightningRepository
import com.desafio.bipa.feature.node_list.R
import com.desafio.bipa.feature.node_list.model.toUi
import com.desafio.bipa.feature.node_list.ui.viewModel.NodeListUiEvent
import com.desafio.bipa.feature.node_list.ui.viewModel.NodeListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class MainCoroutineRule(
    private val testDispatcher: TestDispatcher = StandardTestDispatcher()
) : TestWatcher() {

    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class NodeListViewModelTest {
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun `when init, state should update with nodes`() = runTest {
        val repository = TestLightningRepository()
        val useCase = GetNodeListUseCase(repository)
        val subject = NodeListViewModel(useCase)

        subject.uiState.test {
            val initialState = awaitItem()
            assertEquals(listOf(), initialState.items)
            assertEquals(false, initialState.isRefreshing)
            assertEquals(null, initialState.errorMessage)

            val loadingState = awaitItem()
            assertTrue(loadingState.isRefreshing)

            val successState = awaitItem()
            assertEquals(repository.getNodes().map { it.toUi() }, successState.items)
            assertEquals(false, successState.isRefreshing)
            assertEquals(null, successState.errorMessage)

            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `when init with repository exception, state should update with error message`() = runTest {
        val repository = object : LightningRepository {
            override suspend fun getNodes(): List<Node> {
                throw RuntimeException()
            }
        }
        val useCase = GetNodeListUseCase(repository)
        val subject = NodeListViewModel(useCase)

        subject.uiState.test {
            val initialState = awaitItem()
            assertEquals(listOf(), initialState.items)
            assertEquals(false, initialState.isRefreshing)
            assertEquals(null, initialState.errorMessage)

            val loadingState = awaitItem()
            assertTrue(loadingState.isRefreshing)

            val successState = awaitItem()
            assertEquals(listOf(), successState.items)
            assertEquals(false, successState.isRefreshing)
            assertEquals(R.string.error_message, successState.errorMessage)

            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `onEvent ErrorMessageShown should clear error message`() = runTest {
        val repository = object : LightningRepository {
            override suspend fun getNodes(): List<Node> {
                throw RuntimeException()
            }
        }
        val useCase = GetNodeListUseCase(repository)
        val subject = NodeListViewModel(useCase)

        subject.uiState.test {
            awaitItem() // initial state
            awaitItem() // refreshing state
            awaitItem() // error state

            subject.onEvent(NodeListUiEvent.ErrorMessageShown)

            val clearedState = awaitItem() // state cleared by ErrorMessageShown
            assertEquals(false, clearedState.isRefreshing)
            assertEquals(emptyList(), clearedState.items)
            assertEquals(null, clearedState.errorMessage)

            cancelAndIgnoreRemainingEvents()
        }
    }
}