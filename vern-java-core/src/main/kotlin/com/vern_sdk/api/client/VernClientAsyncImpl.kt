// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.client

import com.vern_sdk.api.core.ClientOptions
import com.vern_sdk.api.core.getPackageVersion
import com.vern_sdk.api.services.async.RunServiceAsync
import com.vern_sdk.api.services.async.RunServiceAsyncImpl
import java.util.function.Consumer

class VernClientAsyncImpl(private val clientOptions: ClientOptions) : VernClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: VernClient by lazy { VernClientImpl(clientOptions) }

    private val withRawResponse: VernClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val runs: RunServiceAsync by lazy { RunServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): VernClient = sync

    override fun withRawResponse(): VernClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VernClientAsync =
        VernClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun runs(): RunServiceAsync = runs

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VernClientAsync.WithRawResponse {

        private val runs: RunServiceAsync.WithRawResponse by lazy {
            RunServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VernClientAsync.WithRawResponse =
            VernClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun runs(): RunServiceAsync.WithRawResponse = runs
    }
}
