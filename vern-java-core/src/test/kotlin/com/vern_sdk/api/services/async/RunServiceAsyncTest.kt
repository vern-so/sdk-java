// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.services.async

import com.vern_sdk.api.client.okhttp.VernOkHttpClientAsync
import com.vern_sdk.api.core.JsonValue
import com.vern_sdk.api.models.runs.RunCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RunServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = VernOkHttpClientAsync.builder().apiKey("My API Key").build()
        val runServiceAsync = client.runs()

        val runFuture =
            runServiceAsync.create(
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

        val run = runFuture.get()
        run.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = VernOkHttpClientAsync.builder().apiKey("My API Key").build()
        val runServiceAsync = client.runs()

        val runFuture = runServiceAsync.retrieve("id")

        val run = runFuture.get()
        run.validate()
    }
}
