package com.desafio.bipa.core.data.repository

import com.desafio.bipa.core.data.model.asNode
import com.desafio.bipa.core.network.RemoteDataSource
import com.desafio.bipa.core.network.model.NetworkLocalizedLocation
import com.desafio.bipa.core.network.model.NetworkNode
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class LightningRepositoryTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testScope = TestScope(UnconfinedTestDispatcher())

    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var subject: LightningRepositoryImpl

    private val testNetworkNodes = listOf(
        NetworkNode(
            publicKey = "publickey1",
            alias = "ALIAS1",
            channels = 2941,
            capacity = 8662,
            firstSeen = 1522941222,
            updatedAt = 1732964600,
            city = NetworkLocalizedLocation(ptBR = "Nova Iorque", en = "New York"),
            country = NetworkLocalizedLocation(
                ptBR = "Estados Unidos",
                en = "United States"
            )
        ),
        NetworkNode(
            publicKey = "publickey2",
            alias = "ALIAS2",
            channels = 1722,
            capacity = 824576967,
            firstSeen = 1529506821,
            updatedAt = 1732964236,
            city = NetworkLocalizedLocation(ptBR = null, en = "Frankfurt"),
            country = NetworkLocalizedLocation(ptBR = null, en = "Germany")
        ),
        NetworkNode(
            publicKey = "publickey3",
            alias = "ALIAS3",
            channels = 1462,
            capacity = 17574002449,
            firstSeen = 1601429940,
            updatedAt = 1732964479,
            city = null,
            country = NetworkLocalizedLocation(ptBR = null, en = "Germany")
        ),
    )

    @Before
    fun setup() {
        remoteDataSource = object : RemoteDataSource {
            override suspend fun getNodes(): List<NetworkNode> = testNetworkNodes
        }

        subject = LightningRepositoryImpl(remoteDataSource)
    }

    @Test
    fun `lightningRepositoryImpl should return correct Node list from remoteDataSource`() {
        testScope.runTest {
            assertEquals(testNetworkNodes.map { it.asNode() }, subject.getNodes())
        }
    }
}