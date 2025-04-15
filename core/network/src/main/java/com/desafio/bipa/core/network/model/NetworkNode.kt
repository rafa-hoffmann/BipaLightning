package com.desafio.bipa.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkNode(
    @SerialName("publicKey") val publicKey: String,
    @SerialName("alias") val alias: String,
    @SerialName("channels") val channels: Long,
    @SerialName("capacity") val capacity: Long,
    @SerialName("firstSeen") val firstSeen: Long,
    @SerialName("updatedAt") val updatedAt: Long,
    @SerialName("city") val city: NetworkLocalizedLocation?,
    @SerialName("country") val country: NetworkLocalizedLocation?,
)

@Serializable
data class NetworkLocalizedLocation(
    @SerialName("pt-BR") val ptBR: String? = null,
    @SerialName("en") val en: String? = null,
)