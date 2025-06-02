package com.vern_sdk.api.errors

class VernIoException @JvmOverloads constructor(message: String? = null, cause: Throwable? = null) :
    VernException(message, cause)
