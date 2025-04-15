package com.desafio.bipa.core.data.model

import com.desafio.bipa.core.network.model.NetworkLocalizedLocation
import com.desafio.bipa.core.network.model.NetworkNode
import junit.framework.TestCase.assertNull
import kotlinx.datetime.Instant
import org.junit.Test
import kotlin.test.assertEquals

class NetworkNodeTest {

    @Test
    fun `when NetworkNode, with city and country, asNode, should return correct Node`() {
        val networkNode = NetworkNode(
            publicKey = "publickey1",
            alias = "alias1",
            channels = 2731,
            capacity = 3220,
            firstSeen = 5000,
            updatedAt = 2696,
            city = NetworkLocalizedLocation(ptBR = "Nova Iorque", en = "New York"),
            country = NetworkLocalizedLocation(ptBR = "Estados Unidos", en = "United States")
        )
        val node = networkNode.asNode()
        assertEquals("publickey1", node.publicKey)
        assertEquals("alias1", node.alias)
        assertEquals(2731, node.channels)
        assertEquals(3220, node.capacity)
        assertEquals(Instant.fromEpochSeconds(5000), node.firstSeen)
        assertEquals(Instant.fromEpochSeconds(2696), node.updatedAt)
        assertEquals("Nova Iorque", node.city?.ptBR)
        assertEquals("New York", node.city?.en)
        assertEquals("Estados Unidos", node.country?.ptBR)
        assertEquals("United States", node.country?.en)
    }

    @Test
    fun `when NetworkNode, without city and country, asNode, should return correct Node with null values`() {
        val networkNode = NetworkNode("publickey1", "alias1", 2731, 3220, 5000, 2696, null, null)
        val node = networkNode.asNode()
        assertNull(node.city)
        assertNull(node.country)
    }
}