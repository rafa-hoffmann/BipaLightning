package com.desafio.bipa.core.domain.di

import com.desafio.bipa.core.domain.use_case.GetNodeListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetNodeListUseCase(get()) }
}