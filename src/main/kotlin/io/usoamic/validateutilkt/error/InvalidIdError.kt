package io.usoamic.validateutilkt.error

import java.math.BigInteger

class InvalidIdError(
    private val minId: BigInteger? = null,
    private val maxId: BigInteger? = null
) : ValidateUtilError()