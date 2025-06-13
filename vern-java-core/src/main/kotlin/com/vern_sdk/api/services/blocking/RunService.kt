// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.vern_sdk.api.core.ClientOptions
import com.vern_sdk.api.core.RequestOptions
import com.vern_sdk.api.core.http.HttpResponseFor
import com.vern_sdk.api.models.runs.RunCreateParams
import com.vern_sdk.api.models.runs.RunCreateResponse
import com.vern_sdk.api.models.runs.RunRetrieveParams
import com.vern_sdk.api.models.runs.RunRetrieveResponse
import java.util.function.Consumer

interface RunService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RunService

    /** Executes a task with the provided inputs */
    fun create(params: RunCreateParams): RunCreateResponse = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunCreateResponse

    /** Retrieves the details of a specific task run */
    fun retrieve(id: String): RunRetrieveResponse = retrieve(id, RunRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        id: String,
        params: RunRetrieveParams = RunRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        id: String,
        params: RunRetrieveParams = RunRetrieveParams.none(),
    ): RunRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunRetrieveResponse

    /** @see [retrieve] */
    fun retrieve(params: RunRetrieveParams): RunRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(id: String, requestOptions: RequestOptions): RunRetrieveResponse =
        retrieve(id, RunRetrieveParams.none(), requestOptions)

    /** A view of [RunService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RunService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /runs`, but is otherwise the same as
         * [RunService.create].
         */
        @MustBeClosed
        fun create(params: RunCreateParams): HttpResponseFor<RunCreateResponse> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunCreateResponse>

        /**
         * Returns a raw HTTP response for `get /runs/{id}`, but is otherwise the same as
         * [RunService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<RunRetrieveResponse> =
            retrieve(id, RunRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: RunRetrieveParams = RunRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: RunRetrieveParams = RunRetrieveParams.none(),
        ): HttpResponseFor<RunRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunRetrieveResponse>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: RunRetrieveParams): HttpResponseFor<RunRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunRetrieveResponse> =
            retrieve(id, RunRetrieveParams.none(), requestOptions)
    }
}
