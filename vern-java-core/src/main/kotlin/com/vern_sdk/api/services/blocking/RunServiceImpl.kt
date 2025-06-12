// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.services.blocking

import com.vern_sdk.api.core.ClientOptions
import com.vern_sdk.api.core.JsonValue
import com.vern_sdk.api.core.RequestOptions
import com.vern_sdk.api.core.checkRequired
import com.vern_sdk.api.core.handlers.errorHandler
import com.vern_sdk.api.core.handlers.jsonHandler
import com.vern_sdk.api.core.handlers.withErrorHandler
import com.vern_sdk.api.core.http.HttpMethod
import com.vern_sdk.api.core.http.HttpRequest
import com.vern_sdk.api.core.http.HttpResponse.Handler
import com.vern_sdk.api.core.http.HttpResponseFor
import com.vern_sdk.api.core.http.json
import com.vern_sdk.api.core.http.parseable
import com.vern_sdk.api.core.prepare
import com.vern_sdk.api.models.runs.RunCreateParams
import com.vern_sdk.api.models.runs.RunCreateResponse
import com.vern_sdk.api.models.runs.RunRetrieveParams
import com.vern_sdk.api.models.runs.RunRetrieveResponse
import kotlin.jvm.optionals.getOrNull

class RunServiceImpl internal constructor(private val clientOptions: ClientOptions) : RunService {

    private val withRawResponse: RunService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RunService.WithRawResponse = withRawResponse

    override fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions,
    ): RunCreateResponse =
        // post /runs
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions,
    ): RunRetrieveResponse =
        // get /runs/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RunService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<RunCreateResponse> =
            jsonHandler<RunCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("runs")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<RunRetrieveResponse> =
            jsonHandler<RunRetrieveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("runs", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
