package com.kotlin.kotlindemo.integration

import domain.PairingMatrixData
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters
import java.nio.charset.StandardCharsets

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun `get suggestion for pairing`() {
        webTestClient.post()
                .uri("/pairing/suggestion")
                .body(BodyInserters.fromObject(listOf(
                        PairingMatrixData(pair1 = "a1", pair2 = "b1", days = 2),
                        PairingMatrixData(pair1 = "a1", pair2 = "b2", days = 3),
                        PairingMatrixData(pair1 = "a2", pair2 = "b2", days = 1),
                        PairingMatrixData(pair1 = "a2", pair2 = "b1", days = 7)
                )))
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith { m ->
                    assertEquals("[{\"first\":\"a1\",\"second\":\"b1\"},{\"first\":\"b1\",\"second\":\"a1\"},{\"first\":\"b2\",\"second\":\"a2\"},{\"first\":\"a2\",\"second\":\"b2\"}]",
                            String(m.responseBodyContent!!, StandardCharsets.UTF_8))
                }
    }
}