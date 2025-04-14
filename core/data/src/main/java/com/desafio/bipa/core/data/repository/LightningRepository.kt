package com.desafio.bipa.core.data.repository

import com.desafio.bipa.core.data.model.Node

interface LightningRepository {

    suspend fun getNodes(): List<Node>
}