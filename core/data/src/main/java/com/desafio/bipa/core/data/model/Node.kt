package com.desafio.bipa.core.data.model

import kotlinx.datetime.Instant

data class Node(
    val publicKey: String,
    val alias: String,
    val channels: Long,
    val firstSeen: Instant,
    val updatedAt: Instant,
    val city: LocalizedLocation?,
    val country: LocalizedLocation?,
)
