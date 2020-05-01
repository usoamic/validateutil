package io.usoamic.validateutilkt_test

import io.usoamic.validateutilkt.ValidateUtil
import io.usoamic.validateutilkt.error.*
import org.junit.jupiter.api.Test

class ValidateUtilTest {
    @Test
    fun validatePasswordTest() {
        ValidateUtil.validatePassword("1!")

        try {
            ValidateUtil.validatePassword("")
        } catch (e: Exception) {
            assert(e is EmptyPasswordError)
        }
    }

    @Test
    fun validatePasswordsTest() {
        ValidateUtil.validatePasswords("1234", "1234")

        try {
            ValidateUtil.validatePasswords("", "1")
        }
        catch (e: Exception) {
            assert(e is EmptyPasswordError)
        }

        try {
            ValidateUtil.validatePasswords("1", "")
        }
        catch (e: java.lang.Exception) {
            assert(e is EmptyConfirmPasswordError)
        }

        try {
            ValidateUtil.validatePasswords("1", "2")
        }
        catch (e: Exception) {
            assert(e is PasswordsDoNotMatchError)
        }
    }

    @Test
    fun validateDescriptionTest() {
        ValidateUtil.validateDescription("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")

        try {
            ValidateUtil.validateDescription("")
        } catch (e: Exception) {
            assert(e is EmptyDescriptionError)
        }
    }

    @Test
    fun validateNoteContentTest() {
        ValidateUtil.validateNoteContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
        try {
            ValidateUtil.validateNoteContent("")
        } catch (e: Exception) {
            assert(e is EmptyNoteContentError)
        }
    }

    @Test
    fun validateCommentTest() {
        ValidateUtil.validateComment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.")
        try {
            ValidateUtil.validateComment("")
        } catch (e: Exception) {
            assert(e is EmptyCommentError)
        }
    }

    @Test
    fun validatePrivateKeyTest() {
        ValidateUtil.validatePrivateKey("d5d97f6ab07c3de19e4b7a67fc5f3458b4faf968a109aaeec327e4c2cd0ab484")
        try {
            ValidateUtil.validatePrivateKey("")
        } catch (e: Exception) {
            assert(e is EmptyPrivateKeyError)
        }

        try {
            ValidateUtil.validatePrivateKey("0x0")
        } catch (e: Exception) {
            assert(e is InvalidPrivateKeyError)
        }
    }

    @Test
    fun validateMnemonicPhraseTest() {
        ValidateUtil.validateMnemonicPhrase("denial wrist culture into guess parade lesson black member shove wisdom strike")

        try {
            ValidateUtil.validateMnemonicPhrase("")
        } catch (e: Exception) {
            assert(e is EmptyMnemonicPhraseError)
        }

        try {
            ValidateUtil.validateMnemonicPhrase("qwerty123")
        } catch (e: Exception) {
            assert(e is InvalidMnemonicPhraseError)
        }
    }

    @Test
    fun validateAddressTest() {
        val address = "0xcabE4d50Fe44adc481FE965ecfc1B0B9a4389640"
        ValidateUtil.validateAddress(address)

        try {
            ValidateUtil.validateAddress("")
        } catch (e: Exception) {
            assert(e is EmptyAddressError)
        }

        try {
            ValidateUtil.validateAddress("0x01")
        } catch (e: Exception) {
            assert(e is InvalidAddressError)
        }
    }

    @Test
    fun validateTransferValueTest() {
        ValidateUtil.validateTransferValue("1")

        try {
            ValidateUtil.validateTransferValue("")
        } catch (e: Exception) {
            assert(e is EmptyValueError)
        }

        try {
            ValidateUtil.validateTransferValue("qwerty")
        } catch (e: Exception) {
            e.printStackTrace()
            assert(e is InvalidValueError)
        }
    }

    @Test
    fun validateAppIdTest() {
        ValidateUtil.validateAppId("io.usoamic.app")
        try {
            ValidateUtil.validateAppId("")
        } catch (e: Exception) {
            assert(e is EmptyAppIdError)
        }
    }

    @Test
    fun validatePurchaseIdTest() {
        ValidateUtil.validatePurchaseId("io.usoamic.app.purchase1")
        try {
            ValidateUtil.validatePurchaseId("")
        } catch (e: Exception) {
            assert(e is EmptyPurchaseIdError)
        }
    }

    @Test
    fun validateIdTest() {
        ValidateUtil.validateId("1")
        try {
            ValidateUtil.validateId("")
        } catch (e: Exception) {
            assert(e is InvalidIdError)
        }

        try {
            ValidateUtil.validateId("-1")
        } catch (e: Exception) {
            assert(e is InvalidIdError)
        }
    }
}