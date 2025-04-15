package com.desafio.bipa.core.common

import org.junit.Test
import kotlin.test.assertEquals

class UtilsTest {

    @Test
    fun `when convert satoshi to btc, should return correct btc value`() {
        val satoshi = 550_000L
        val btc = convertSatoshiToBtc(satoshi)
        assertEquals("0,00550000", btc)
    }
}