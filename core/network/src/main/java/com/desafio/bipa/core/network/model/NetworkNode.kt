package com.desafio.bipa.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkNode(
    @SerialName("publicKey") val publicKey: String,
    @SerialName("alias") val alias: String,
    @SerialName("channels") val channels: Long,
    @SerialName("firstSeen") val firstSeen: Long,
    @SerialName("updatedAt") val updatedAt: Long,
    @SerialName("city") val city: LocalizedLocation?,
    @SerialName("country") val country: LocalizedLocation?,
)

@Serializable
data class LocalizedLocation(
    @SerialName("pt-BR") val ptBR: String?,
    @SerialName("en") val en: String?,
)