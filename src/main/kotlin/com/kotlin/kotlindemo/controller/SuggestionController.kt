package com.kotlin.kotlindemo.controller

import com.kotlin.kotlindemo.service.PairingMatrixService
import domain.PairingMatrixData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class SuggestionController {
    @Autowired
    lateinit var pairingMatrixService: PairingMatrixService

    @PostMapping("/dummy1")
    fun getPairingSuggestion(@RequestBody pairingData: Mono<List<PairingMatrixData>>) : Flux<Pair<String, String>> {
        return pairingMatrixService.getSuggestion(pairingMatrixData = pairingData)
    }
}



