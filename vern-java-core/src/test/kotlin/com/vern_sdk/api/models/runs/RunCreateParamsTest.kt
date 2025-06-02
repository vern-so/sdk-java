// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.models.runs

import com.vern_sdk.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RunCreateParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
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
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.taskId()).isEqualTo("task_123456")
        assertThat(body.inputs())
            .contains(
                RunCreateParams.Inputs.builder()
                    .putAdditionalProperty("prompt", JsonValue.from("bar"))
                    .putAdditionalProperty("text", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.profileId()).contains("profileId")
        assertThat(body.url()).contains("https://example.com")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = RunCreateParams.builder().taskId("task_123456").build()

        val body = params._body()

        assertThat(body.taskId()).isEqualTo("task_123456")
    }
}
