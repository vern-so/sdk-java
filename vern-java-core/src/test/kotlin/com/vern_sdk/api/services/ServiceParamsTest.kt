// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.vern_sdk.api.client.VernClient
import com.vern_sdk.api.client.okhttp.VernOkHttpClient
import com.vern_sdk.api.core.JsonValue
import com.vern_sdk.api.models.runs.RunCreateParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

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
    fun create() {
        val runService = client.runs()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

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
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
