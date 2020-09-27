package io.usoamic.validateutilkt

import io.usoamic.validateutilkt.error.*
import org.web3j.crypto.MnemonicUtils
import org.web3j.crypto.WalletUtils
import java.math.BigDecimal
import java.math.BigInteger

object ValidateUtil {
    @JvmStatic
    fun validatePassword(password: String) = apply {
        validateThatNotEmpty(
            password,
            EmptyPasswordError()
        )
    }

    @JvmStatic
    fun validatePasswords(password: String, confirmPassword: String) {
        validateThatNotEmpty(
            password,
            EmptyPasswordError()
        )

        validateThatNotEmpty(
            confirmPassword,
            EmptyConfirmPasswordError()
        )

        if (password != confirmPassword) {
            throw PasswordsDoNotMatchError()
        }
    }

    @JvmStatic
    fun validateDescription(description: String) = apply {
        validateThatNotEmpty(
            description,
            EmptyDescriptionError()
        )
    }

    @JvmStatic
    fun validateNoteContent(content: String) = apply {
        validateThatNotEmpty(
            content,
            EmptyNoteContentError()
        )
    }

    @JvmStatic
    fun validateComment(comment: String) = apply {
        validateThatNotEmpty(
            comment,
            EmptyCommentError()
        )
    }

    @JvmStatic
    fun validatePrivateKey(privateKey: String) = apply {
        validateThatNotEmpty(
            privateKey,
            EmptyPrivateKeyError()
        )
        if (!WalletUtils.isValidPrivateKey(privateKey)) {
            throw InvalidPrivateKeyError()
        }
    }

    @JvmStatic
    fun validateMnemonicPhrase(mnemonicPhrase: String) = apply {
        validateThatNotEmpty(
            mnemonicPhrase,
            EmptyMnemonicPhraseError()
        )
        if (!MnemonicUtils.validateMnemonic(mnemonicPhrase)) {
            throw InvalidMnemonicPhraseError()

        }
    }

    @JvmStatic
    fun validateAddress(address: String) = apply {
        validateThatNotEmpty(
            address,
            EmptyAddressError()
        )
        if (!WalletUtils.isValidAddress(address)) {
            throw InvalidAddressError()
        }
    }

    @JvmStatic
    fun validateTransferValue(value: String) = apply {
        validateThatNotEmpty(
            value,
            EmptyValueError()
        )
        val decimalVal = value.toBigDecimalOrNull() ?: throw InvalidValueError()
        if (decimalVal <= BigDecimal.ZERO) {
            throw InvalidValueError()
        }
    }

    @JvmStatic
    fun validateAppId(appId: String) = apply {
        validateThatNotEmpty(
            appId,
            EmptyAppIdError()
        )
    }

    @JvmStatic
    fun validatePurchaseId(purchaseId: String) = apply {
        validateThatNotEmpty(
            purchaseId,
            EmptyPurchaseIdError()
        )
    }

    @JvmStatic
    fun validateId(id: String) = apply {
        val intId = id.toBigIntegerOrNull() ?: throw InvalidIdError()
        if (intId < BigInteger.ZERO) {
            throw InvalidIdError()
        }
    }

    @JvmStatic
    fun validateIds(vararg ids: String) = apply {
        for (id in ids) {
            validateId(id)
        }
    }

    @JvmStatic
    private fun validateThatNotEmpty(str: String, e: ValidateUtilError) {
        if (str.isEmpty()) {
            throw e
        }
    }
}