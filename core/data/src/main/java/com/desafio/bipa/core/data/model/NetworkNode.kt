package com.desafio.bipa.core.data.model

import com.desafio.bipa.core.network.model.NetworkNode
import kotlinx.datetime.Instant

fun NetworkNode.asNode() = Node(
    publicKey = publicKey,
    alias = alias,
    channels = channels,
    firstSeen = Instant.fromEpochSeconds(firstSeen),
    updatedAt = Instant.fromEpochSeconds(updatedAt),
    city = LocalizedLocation(city?.ptBR, city?.en),
    country = LocalizedLocation(country?.ptBR, country?.en)
)