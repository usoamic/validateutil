package io.usoamic.validateutilkt.error

import java.math.BigInteger

class InvalidIdError(
    val minId: BigInteger? = null,
    val maxId: BigInteger? = null
) : ValidateUtilError()