package com.desafio.bipa.feature.node_list.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafio.bipa.core.domain.use_case.GetNodeListUseCase
import com.desafio.bipa.feature.node_list.R
import com.desafio.bipa.feature.node_list.model.NodeUi
import com.desafio.bipa.feature.node_list.model.toUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NodeListViewModel(
    private val getNodeListUseCase: GetNodeListUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<NodeListUiState> = MutableStateFlow(NodeListUiState())
    val uiState: StateFlow<NodeListUiState> = _uiState.asStateFlow()

    init {
        refreshNodes()
    }

    fun onEvent(event: NodeListUiEvent) {
        when (event) {
            NodeListUiEvent.RefreshNodes -> refreshNodes()
            NodeListUiEvent.ErrorMessageShown -> clearErrorMessage()
        }
    }

    private fun refreshNodes() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isRefreshing = true)
            }

            runCatching {
                getNodeListUseCase()
            }.fold(onSuccess = { items ->
                _uiState.update {
                    it.copy(
                        items = items.map { item -> item.toUi() },
                        isRefreshing = false
                    )
                }
            }, onFailure = {
                _uiState.update {
                    it.copy(isRefreshing = false, errorMessage = R.string.error_message)
                }
            })
        }
    }

    private fun clearErrorMessage() {
        _uiState.update {
            it.copy(errorMessage = null)
        }
    }
}

data class NodeListUiState(
    val items: List<NodeUi> = emptyList(),
    val isRefreshing: Boolean = false,
    val errorMessage: Int? = null
)

sealed interface NodeListUiEvent {
    data object RefreshNodes : NodeListUiEvent
    data object ErrorMessageShown : NodeListUiEvent
}