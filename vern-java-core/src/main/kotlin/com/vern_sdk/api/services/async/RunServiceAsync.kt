// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.services.async

import com.vern_sdk.api.core.RequestOptions
import com.vern_sdk.api.core.http.HttpResponseFor
import com.vern_sdk.api.models.runs.RunCreateParams
import com.vern_sdk.api.models.runs.RunCreateResponse
import com.vern_sdk.api.models.runs.RunRetrieveParams
import com.vern_sdk.api.models.runs.RunRetrieveResponse
import java.util.concurrent.CompletableFuture

interface RunServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Executes a task with the provided inputs */
    fun create(params: RunCreateParams): CompletableFuture<RunCreateResponse> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunCreateResponse>

    /** Retrieves the details of a specific task run */
    fun retrieve(id: String): CompletableFuture<RunRetrieveResponse> =
        retrieve(id, RunRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        id: String,
        params: RunRetrieveParams = RunRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        id: String,
        params: RunRetrieveParams = RunRetrieveParams.none(),
    ): CompletableFuture<RunRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunRetrieveResponse>

    /** @see [retrieve] */
    fun retrieve(params: RunRetrieveParams): CompletableFuture<RunRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<RunRetrieveResponse> =
        retrieve(id, RunRetrieveParams.none(), requestOptions)

    /** A view of [RunServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /runs`, but is otherwise the same as
         * [RunServiceAsync.create].
         */
        fun create(params: RunCreateParams): CompletableFuture<HttpResponseFor<RunCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /runs/{id}`, but is otherwise the same as
         * [RunServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<RunRetrieveResponse>> =
            retrieve(id, RunRetrieveParams.none())

        /** @see [retrieve] */
        fun retrieve(
            id: String,
            params: RunRetrieveParams = RunRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see [retrieve] */
        fun retrieve(
            id: String,
            params: RunRetrieveParams = RunRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>>

        /** @see [retrieve] */
        fun retrieve(
            params: RunRetrieveParams
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>> =
            retrieve(id, RunRetrieveParams.none(), requestOptions)
    }
}
