// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vern_sdk.api.client.okhttp.VernOkHttpClient
import com.vern_sdk.api.core.JsonValue
import com.vern_sdk.api.core.jsonMapper
import com.vern_sdk.api.models.runs.RunCreateResponse
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @BeforeAll
        @JvmStatic
        fun setUp() {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/vern-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = VernOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.runs()).isNotNull()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun runCreateResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val runCreateResponse =
            RunCreateResponse.builder()
                .id("id")
                .inputs(
                    RunCreateResponse.Inputs.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .queuedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedRunCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runCreateResponse),
                jacksonTypeRef<RunCreateResponse>(),
            )

        assertThat(roundtrippedRunCreateResponse).isEqualTo(runCreateResponse)
    }
}
