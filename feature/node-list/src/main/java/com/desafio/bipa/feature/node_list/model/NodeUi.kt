package com.desafio.bipa.feature.node_list.model

import com.desafio.bipa.core.common.convertSatoshiToBtc
import com.desafio.bipa.core.model.Node
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime

data class NodeUi(
    val publicKey: String,
    val alias: String,
    val channels: Long,
    val capacity: String,
    val firstSeen: String,
    val updatedAt: String,
    val city: String?,
    val country: String?
)

internal fun Node.toUi() = NodeUi(
    publicKey = publicKey,
    alias = alias,
    channels = channels,
    capacity = convertSatoshiToBtc(capacity).plus(" BTC"),
    firstSeen = firstSeen.toLocalDateTime(TimeZone.currentSystemDefault())
        .format(dateTimeFormatter),
    updatedAt = updatedAt.toLocalDateTime(TimeZone.currentSystemDefault())
        .format(dateTimeFormatter),
    city = city?.ptBR ?: city?.en,
    country = country?.ptBR ?: country?.en
)

private val dateTimeFormatter = LocalDateTime.Format {
    dayOfMonth()
    char('/')
    monthNumber()
    char('/')
    year()

    char(' ')

    hour()
    char(':')
    minute()
}
