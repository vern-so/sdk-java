@file:JvmName("JsonHandler")

package com.vern_sdk.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vern_sdk.api.core.http.HttpResponse
import com.vern_sdk.api.core.http.HttpResponse.Handler
import com.vern_sdk.api.errors.VernInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw VernInvalidDataException("Error reading response", e)
            }
    }
