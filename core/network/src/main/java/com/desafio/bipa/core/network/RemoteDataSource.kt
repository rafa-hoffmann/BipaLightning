package com.desafio.bipa.core.network

import com.desafio.bipa.core.network.model.NetworkNode

interface RemoteDataSource {

    suspend fun getNodes(): List<NetworkNode>
}