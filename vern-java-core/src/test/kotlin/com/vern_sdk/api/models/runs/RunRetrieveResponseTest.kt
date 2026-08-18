// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.models.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vern_sdk.api.core.JsonValue
import com.vern_sdk.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunRetrieveResponseTest {

    @Test
    fun create() {
        val runRetrieveResponse =
            RunRetrieveResponse.builder()
                .id("id")
                .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .inputs(
                    RunRetrieveResponse.Inputs.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .response(
                    RunRetrieveResponse.Response.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .startedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(RunRetrieveResponse.Status.QUEUED)
                .task("task")
                .build()

        assertThat(runRetrieveResponse.id()).contains("id")
        assertThat(runRetrieveResponse.completedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(runRetrieveResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(runRetrieveResponse.inputs())
            .contains(
                RunRetrieveResponse.Inputs.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(runRetrieveResponse.response())
            .contains(
                RunRetrieveResponse.Response.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(runRetrieveResponse.startedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(runRetrieveResponse.status()).contains(RunRetrieveResponse.Status.QUEUED)
        assertThat(runRetrieveResponse.task()).contains("task")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val runRetrieveResponse =
            RunRetrieveResponse.builder()
                .id("id")
                .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .inputs(
                    RunRetrieveResponse.Inputs.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .response(
                    RunRetrieveResponse.Response.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .startedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(RunRetrieveResponse.Status.QUEUED)
                .task("task")
                .build()

        val roundtrippedRunRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runRetrieveResponse),
                jacksonTypeRef<RunRetrieveResponse>(),
            )

        assertThat(roundtrippedRunRetrieveResponse).isEqualTo(runRetrieveResponse)
    }
}
