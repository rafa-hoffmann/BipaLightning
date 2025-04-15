package com.desafio.bipa.core.model

import kotlinx.datetime.Instant

data class Node(
    val publicKey: String,
    val alias: String,
    val channels: Long,
    val capacity: Long,
    val firstSeen: Instant,
    val updatedAt: Instant,
    val city: LocalizedLocation?,
    val country: LocalizedLocation?,
)
