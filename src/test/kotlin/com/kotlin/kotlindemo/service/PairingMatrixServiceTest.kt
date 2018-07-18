package com.kotlin.kotlindemo.service

import domain.PairingMatrixData
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import reactor.core.publisher.toMono


class PairingMatrixServiceTest {

    lateinit var pairingMatrixService: PairingMatrixService

    @BeforeEach
    internal fun setUp() {
        pairingMatrixService = PairingMatrixService()
    }

    @Test
    fun `should give suggestion for pairing data`() {
        val pairingData = listOf(
                PairingMatrixData(pair1 = "a1", pair2 = "b1", days = 2),
                PairingMatrixData(pair1 = "a1", pair2 = "b2", days = 3),
                PairingMatrixData(pair1 = "a2", pair2 = "b2", days = 1),
                PairingMatrixData(pair1 = "a2", pair2 = "b1", days = 7)
        ).toMono()

        val expected = listOf(Pair("a1", "b1"), Pair("a2", "b2"), Pair("b1", "a1"), Pair("b2", "a2"))

        val suggestion = pairingMatrixService.getSuggestion(pairingData).collectList().block()
        assertTrue(suggestion!!.containsAll(expected))

    }
}