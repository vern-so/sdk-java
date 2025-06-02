// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.client

import com.vern_sdk.api.core.ClientOptions
import com.vern_sdk.api.core.getPackageVersion
import com.vern_sdk.api.services.blocking.RunService
import com.vern_sdk.api.services.blocking.RunServiceImpl

class VernClientImpl(private val clientOptions: ClientOptions) : VernClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: VernClientAsync by lazy { VernClientAsyncImpl(clientOptions) }

    private val withRawResponse: VernClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val runs: RunService by lazy { RunServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): VernClientAsync = async

    override fun withRawResponse(): VernClient.WithRawResponse = withRawResponse

    override fun runs(): RunService = runs

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VernClient.WithRawResponse {

        private val runs: RunService.WithRawResponse by lazy {
            RunServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun runs(): RunService.WithRawResponse = runs
    }
}
