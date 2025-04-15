package com.desafio.bipa.core.testing.repository

import com.desafio.bipa.core.data.repository.LightningRepository
import com.desafio.bipa.core.model.Node
import com.desafio.bipa.core.testing.data.nodeTestData

class TestLightningRepository : LightningRepository {

    override suspend fun getNodes(): List<Node> = nodeTestData
}