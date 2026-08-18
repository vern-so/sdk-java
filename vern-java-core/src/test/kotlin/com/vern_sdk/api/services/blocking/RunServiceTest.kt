// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.services.blocking

import com.vern_sdk.api.client.okhttp.VernOkHttpClient
import com.vern_sdk.api.core.JsonValue
import com.vern_sdk.api.models.runs.RunCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RunServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = VernOkHttpClient.builder().apiKey("My API Key").build()
        val runService = client.runs()

        val run =
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

        run.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = VernOkHttpClient.builder().apiKey("My API Key").build()
        val runService = client.runs()

        val run = runService.retrieve("id")

        run.validate()
    }
}
