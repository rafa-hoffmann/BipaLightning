package com.desafio.bipa.core.network.di

import com.desafio.bipa.core.network.RemoteDataSource
import com.desafio.bipa.core.network.retrofit.LightningNetwork
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single<Json> {
        Json {
            ignoreUnknownKeys = true
        }
    }

    single<RemoteDataSource> {
        LightningNetwork(get())
    }
}