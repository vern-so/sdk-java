// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.vern_sdk.api.client.VernClient
import com.vern_sdk.api.client.okhttp.VernOkHttpClient
import com.vern_sdk.api.core.JsonValue
import com.vern_sdk.api.core.http.Headers
import com.vern_sdk.api.core.jsonMapper
import com.vern_sdk.api.errors.BadRequestException
import com.vern_sdk.api.errors.InternalServerException
import com.vern_sdk.api.errors.NotFoundException
import com.vern_sdk.api.errors.PermissionDeniedException
import com.vern_sdk.api.errors.RateLimitException
import com.vern_sdk.api.errors.UnauthorizedException
import com.vern_sdk.api.errors.UnexpectedStatusCodeException
import com.vern_sdk.api.errors.UnprocessableEntityException
import com.vern_sdk.api.errors.VernException
import com.vern_sdk.api.models.runs.RunCreateParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: VernClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            VernOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate400() {
        val runService = client.runs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate400WithRawResponse() {
        val runService = client.runs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate401() {
        val runService = client.runs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate401WithRawResponse() {
        val runService = client.runs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate403() {
        val runService = client.runs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate403WithRawResponse() {
        val runService = client.runs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate404() {
        val runService = client.runs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate404WithRawResponse() {
        val runService = client.runs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate422() {
        val runService = client.runs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate422WithRawResponse() {
        val runService = client.runs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate429() {
        val runService = client.runs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate429WithRawResponse() {
        val runService = client.runs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate500() {
        val runService = client.runs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate500WithRawResponse() {
        val runService = client.runs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate999() {
        val runService = client.runs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreate999WithRawResponse() {
        val runService = client.runs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runsCreateInvalidJsonBody() {
        val runService = client.runs()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<VernException> {
                runService.create(
                    RunCreateParams.builder()
                        .taskId("task_123456")
                        .inputs(
                            RunCreateParams.Inputs.builder()
                                .putAdditionalProperty("prompt", JsonValue.from("bar"))
                                .putAdditionalProperty("text", JsonValue.from("bar"))
                                .build()
                        )
                        .profileId("profileId")
                        .url("https://example.com")
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
