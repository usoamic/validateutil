package io.usoamic.validateutilkt.error

import java.lang.Exception

open class ValidateUtilError(override val message: String = "") : Exception(message)