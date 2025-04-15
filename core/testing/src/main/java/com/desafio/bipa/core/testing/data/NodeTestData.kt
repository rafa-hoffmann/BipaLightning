package com.desafio.bipa.core.testing.data

import com.desafio.bipa.core.model.LocalizedLocation
import com.desafio.bipa.core.model.Node
import kotlinx.datetime.Instant

val nodeTestData: List<Node> = listOf(
    Node(
        publicKey = "publickey1",
        alias = "ALIAS1",
        channels = 2941,
        capacity = 8662,
        firstSeen = Instant.fromEpochSeconds(1522941222),
        updatedAt = Instant.fromEpochSeconds(1732964600),
        city = LocalizedLocation(ptBR = "Nova Iorque", en = "New York"),
        country = LocalizedLocation(ptBR = "Estados Unidos", en = "United States")
    ),
    Node(
        publicKey = "publickey2",
        alias = "ALIAS2",
        channels = 1722,
        capacity = 824576967,
        firstSeen = Instant.fromEpochSeconds(1529506821),
        updatedAt = Instant.fromEpochSeconds(1732964236),
        city = LocalizedLocation(ptBR = null, en = "Frankfurt"),
        country = LocalizedLocation(ptBR = null, en = "Germany")
    ),
    Node(
        publicKey = "publickey3",
        alias = "ALIAS3",
        channels = 1462,
        capacity = 17574002449,
        firstSeen = Instant.fromEpochSeconds(1601429940),
        updatedAt = Instant.fromEpochSeconds(1732964479),
        city = null,
        country = LocalizedLocation(ptBR = null, en = "Germany")
    ),
)