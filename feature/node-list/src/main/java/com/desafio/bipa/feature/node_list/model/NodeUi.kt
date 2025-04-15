package com.desafio.bipa.feature.node_list.model

data class NodeUi(
    val publicKey: String,
    val alias: String,
    val channels: Int,
    val capacity: String,
    val firstSeen: String,
    val updatedAt: String,
    val city: String,
    val country: String
)
