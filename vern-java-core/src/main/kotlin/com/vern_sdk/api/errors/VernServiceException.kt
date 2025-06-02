// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.errors

import com.vern_sdk.api.core.JsonValue
import com.vern_sdk.api.core.http.Headers

abstract class VernServiceException
protected constructor(message: String, cause: Throwable? = null) : VernException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
