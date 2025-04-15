package com.desafio.bipa.feature.node_list.di

import com.desafio.bipa.feature.node_list.ui.viewModel.NodeListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val nodeListModule = module {
    viewModelOf(::NodeListViewModel)
}