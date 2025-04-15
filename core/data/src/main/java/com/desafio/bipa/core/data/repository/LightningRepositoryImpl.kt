package com.desafio.bipa.core.data.repository

import com.desafio.bipa.core.model.Node
import com.desafio.bipa.core.data.model.asNode
import com.desafio.bipa.core.network.RemoteDataSource

internal class LightningRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : LightningRepository {

    override suspend fun getNodes(): List<Node> = remoteDataSource.getNodes().map { it.asNode() }
}