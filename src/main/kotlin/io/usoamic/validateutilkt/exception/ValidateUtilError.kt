package io.usoamic.validateutilkt.exception

import java.lang.Exception

open class ValidateUtilError(override val message: String = "") : Exception(message)