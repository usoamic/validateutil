package io.usoamic.validateutilkt

import io.usoamic.validateutilkt.exception.*
import org.web3j.crypto.MnemonicUtils
import org.web3j.crypto.WalletUtils
import java.math.BigDecimal
import java.math.BigInteger

class ValidateUtil {
    companion object {
        fun validatePassword(password: String) = apply {
            validateThatNotEmpty(
                password,
                EmptyPasswordError()
            )
        }

        fun validatePasswords(password: String, confirmPassword: String) {
            validateThatNotEmpty(
                password,
                EmptyPasswordError()
            )

            validateThatNotEmpty(
                confirmPassword,
                EmptyConfirmPasswordError()
            )

            if(password != confirmPassword) {
                throw PasswordsDoNotMatchError()
            }
        }

        fun validateDescription(description: String) = apply {
            validateThatNotEmpty(
                description,
                EmptyDescriptionError()
            )
        }

        fun validateNoteContent(content: String) = apply {
            validateThatNotEmpty(
                content,
                EmptyNoteContentError()
            )
        }

        fun validateComment(comment: String) = apply {
            validateThatNotEmpty(
                comment,
                EmptyCommentError()
            )
        }

        fun validatePrivateKey(privateKey: String) = apply {
            validateThatNotEmpty(
                privateKey,
                EmptyPrivateKeyError()
            )
            if (!WalletUtils.isValidPrivateKey(privateKey)) {
                throw InvalidPrivateKeyError()
            }
        }

        fun validateMnemonicPhrase(mnemonicPhrase: String) = apply {
            validateThatNotEmpty(
                mnemonicPhrase,
                EmptyMnemonicPhraseError()
            )
            if (!MnemonicUtils.validateMnemonic(mnemonicPhrase)) {
                throw InvalidMnemonicPhraseError()

            }
        }

        fun validateAddress(address: String) = apply {
            validateThatNotEmpty(
                address,
                EmptyAddressError()
            )
            if (!WalletUtils.isValidAddress(address)) {
                throw InvalidAddressError()
            }
        }

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

        fun validateAppId(appId: String) = apply {
            validateThatNotEmpty(
                appId,
                EmptyAppIdError()
            )
        }

        fun validatePurchaseId(purchaseId: String) = apply {
            validateThatNotEmpty(
                purchaseId,
                EmptyPurchaseIdError()
            )
        }

        fun validateId(id: String) = apply {
            val intId = id.toBigIntegerOrNull() ?: throw InvalidIdError()
            if (intId < BigInteger.ZERO) {
                throw InvalidIdError()
            }
        }

        fun validateIds(vararg ids: String) = apply {
            for (id in ids) {
                validateId(id)
            }
        }

        private fun validateThatNotEmpty(str: String, e: ValidateUtilError) {
            if (str.isEmpty()) {
                throw e
            }
        }
    }
}