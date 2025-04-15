package com.desafio.bipa.core.data.model

import com.desafio.bipa.core.model.LocalizedLocation
import com.desafio.bipa.core.model.Node
import com.desafio.bipa.core.network.model.NetworkNode
import kotlinx.datetime.Instant

fun NetworkNode.asNode() = Node(
    publicKey = publicKey,
    alias = alias,
    channels = channels,
    capacity = capacity,
    firstSeen = Instant.fromEpochSeconds(firstSeen),
    updatedAt = Instant.fromEpochSeconds(updatedAt),
    city = city?.let { LocalizedLocation(it.ptBR, it.en) },
    country = country?.let { LocalizedLocation(it.ptBR, it.en) }
)