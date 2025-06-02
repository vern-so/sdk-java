@file:JvmName("StringHandler")

package com.vern_sdk.api.core.handlers

import com.vern_sdk.api.core.http.HttpResponse
import com.vern_sdk.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
