// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.models.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vern_sdk.api.core.JsonValue
import com.vern_sdk.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RunCreateResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
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

        assertThat(runCreateResponse.id()).contains("id")
        assertThat(runCreateResponse.inputs())
            .contains(
                RunCreateResponse.Inputs.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(runCreateResponse.queuedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
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
