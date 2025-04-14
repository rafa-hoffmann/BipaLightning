package com.desafio.bipa.core.data.di

import com.desafio.bipa.core.data.repository.LightningRepository
import com.desafio.bipa.core.data.repository.LightningRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<LightningRepository> { LightningRepositoryImpl(get()) }
}