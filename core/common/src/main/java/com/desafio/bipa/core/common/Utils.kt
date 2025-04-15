package com.desafio.bipa.core.common

import java.util.Locale

fun convertSatoshiToBtc(sats: Long): String {
    val btc = sats.toDouble() / 100000000
    return String.format(Locale.getDefault(), "%.8f", btc)
}