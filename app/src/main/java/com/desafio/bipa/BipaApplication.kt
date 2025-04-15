package com.desafio.bipa

import android.app.Application
import com.desafio.bipa.core.data.di.dataModule
import com.desafio.bipa.core.domain.di.domainModule
import com.desafio.bipa.core.network.di.networkModule
import com.desafio.bipa.feature.node_list.di.nodeListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BipaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BipaApplication)
            modules(dataModule, domainModule, networkModule, nodeListModule)
        }
    }
}