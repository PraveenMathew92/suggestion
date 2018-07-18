package com.kotlin.kotlindemo.controller

import com.kotlin.kotlindemo.MockitoExtension
import com.kotlin.kotlindemo.service.PairingMatrixService
import domain.PairingMatrixData
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import reactor.core.publisher.toMono

@RunWith(MockitoJUnitRunner::class)
@ExtendWith(MockitoExtension::class)
class SuggestionControllerTest {

    @Mock
    lateinit var pairingMatrixService: PairingMatrixService

    @InjectMocks
    lateinit var controller: SuggestionController

    @Test
    fun `should call suggestion pairingMatrixService getSuggestion`() {
        val pairingData = listOf(PairingMatrixData(pair1 = "pair1", pair2 = "pair2", days = 3),
                PairingMatrixData(pair1 = "pair3", pair2 = "pair1", days = 5)).toMono()
        controller.getPairingSuggestion(pairingData = pairingData)
        verify(pairingMatrixService, times(1)).getSuggestion(pairingData)

    }
}
