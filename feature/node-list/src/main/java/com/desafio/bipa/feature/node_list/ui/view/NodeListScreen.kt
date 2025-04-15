package com.desafio.bipa.feature.node_list.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.desafio.bipa.core.design_system.BipaLightningTheme
import com.desafio.bipa.feature.node_list.model.NodeUi
import com.desafio.bipa.feature.node_list.ui.viewModel.NodeListUiEvent
import com.desafio.bipa.feature.node_list.ui.viewModel.NodeListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NodeListRoute(viewModel: NodeListViewModel = koinViewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val errorMessage = state.errorMessage?.let { stringResource(id = it) }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            snackbarHostState.showSnackbar(message = it)
            viewModel.onEvent(NodeListUiEvent.ErrorMessageShown)
        }
    }

    NodeListScreen(
        items = state.items,
        snackbarHostState = snackbarHostState,
        isRefreshing = state.isRefreshing,
        onEvent = viewModel::onEvent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NodeListScreen(
    items: List<NodeUi>,
    isRefreshing: Boolean,
    onEvent: (NodeListUiEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
) {
    Scaffold(snackbarHost = {
        SnackbarHost(snackbarHostState)
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            PullToRefreshBox(
                modifier = Modifier.fillMaxWidth(),
                isRefreshing = isRefreshing,
                onRefresh = {
                    onEvent(NodeListUiEvent.RefreshNodes)
                }) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        modifier = Modifier.padding(vertical = 12.dp),
                        text = "Nodes",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(items) {
                            NodeItem(
                                modifier = Modifier.testTag("NodeItem"),
                                publicKey = it.publicKey,
                                alias = it.alias,
                                channels = it.channels,
                                capacity = it.capacity,
                                firstSeen = it.firstSeen,
                                updatedAt = it.updatedAt,
                                city = it.city,
                                country = it.country
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun NodeListPreview() {
    BipaLightningTheme {
        NodeListScreen(
            items = listOf(
                NodeUi(
                    publicKey = "12dasdouind12089nio2134oni124oni",
                    alias = "legimus",
                    channels = 6262,
                    capacity = "Glenwood",
                    firstSeen = "constituto",
                    updatedAt = "in",
                    city = "Sommersdale",
                    country = "Peru"
                ), NodeUi(
                    publicKey = "1241782b9dnas9nd09i0n921244dfdssads",
                    alias = "ut",
                    channels = 4803,
                    capacity = "Fulton Oaks",
                    firstSeen = "perpetua",
                    updatedAt = "aptent",
                    city = "Bella Vista",
                    country = "Russia"
                ), NodeUi(
                    publicKey = "1b824uyb807219bu0429bu91ui2n3931298",
                    alias = "non",
                    channels = 1115,
                    capacity = "Vice City",
                    firstSeen = "efficitur",
                    updatedAt = "epicurei",
                    city = "Golden Coast",
                    country = "Saint Vincent and the Grenadines"

                )
            ), isRefreshing = false, onEvent = {}, snackbarHostState = SnackbarHostState()
        )
    }
}
