package com.desafio.bipa.core.domain.use_case

import com.desafio.bipa.core.testing.data.nodeTestData
import com.desafio.bipa.core.testing.repository.TestLightningRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetNodeListUseCaseTest {

    private lateinit var subject: GetNodeListUseCase

    @Before
    fun setup() {
        subject = GetNodeListUseCase(lightningRepository = TestLightningRepository())
    }

    @Test
    fun `when GetNodeListUseCase, should return correct Node list`() {
        runTest {
            assertEquals(nodeTestData, subject())
        }
    }
}