package com.kotlin.kotlindemo.service

import domain.PairingMatrixData
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PairingMatrixService {
    fun getSuggestion(pairingMatrixData: Mono<List<PairingMatrixData>>): Flux<Pair<String, String>> {
        return pairingMatrixData
                .map(this::byPairingDays)
                .flatMapMany { Flux.fromIterable(it) }

    }

    private fun byPairingDays(p: List<PairingMatrixData>): List<Pair<String, String>> {
        return p.fold(emptyList<String>()) { acc, (pair1, pair2) -> acc + listOf(pair1, pair2) }
                .distinct()
                .map { m -> Pair(m, p.filter { d -> d.contains(m) }.sortedWith(compareBy { it.days })) }
                .map { Pair(it.first, it.second.first().getPair(it.first)) }
    }
}