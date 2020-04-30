package io.usoamic.validateutilkt_test

import io.usoamic.validateutilkt.ValidateUtil
import io.usoamic.validateutilkt.error.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidateUtilTest {
    @Test
    fun validatePasswordTest() {
        ValidateUtil.validatePassword("1!")

        assertThrows<EmptyPasswordError> {
            ValidateUtil.validatePassword("")
        }
    }

    @Test
    fun validatePasswordsTest() {
        ValidateUtil.validatePasswords("1234", "1234")

        assertThrows<EmptyPasswordError> {
            ValidateUtil.validatePasswords("", "1")
        }

        assertThrows<EmptyConfirmPasswordError> {
            ValidateUtil.validatePasswords("1", "")
        }

        assertThrows<PasswordsDoNotMatchError> {
            ValidateUtil.validatePasswords("1", "2")
        }
    }

    @Test
    fun validateDescriptionTest() {
        ValidateUtil.validateDescription("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")

        assertThrows<EmptyDescriptionError> {
            ValidateUtil.validateDescription("")
        }
    }

    @Test
    fun validateNoteContentTest() {
        ValidateUtil.validateNoteContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")

        assertThrows<EmptyNoteContentError> {
            ValidateUtil.validateNoteContent("")
        }
    }

    @Test
    fun validateCommentTest() {
        ValidateUtil.validateComment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.")

        assertThrows<EmptyCommentError> {
            ValidateUtil.validateComment("")
        }
    }

    @Test
    fun validatePrivateKeyTest() {
        ValidateUtil.validatePrivateKey("d5d97f6ab07c3de19e4b7a67fc5f3458b4faf968a109aaeec327e4c2cd0ab484")

        assertThrows<EmptyPrivateKeyError> {
            ValidateUtil.validatePrivateKey("")
        }

        assertThrows<InvalidPrivateKeyError> {
            ValidateUtil.validatePrivateKey("0x0")
        }
    }

    @Test
    fun validateMnemonicPhraseTest() {
        ValidateUtil.validateMnemonicPhrase("denial wrist culture into guess parade lesson black member shove wisdom strike")

        assertThrows<EmptyMnemonicPhraseError> {
            ValidateUtil.validateMnemonicPhrase("")
        }

        assertThrows<InvalidMnemonicPhraseError> {
            ValidateUtil.validateMnemonicPhrase("qwerty123")
        }
    }

    @Test
    fun validateAddressTest() {
        ValidateUtil.validateAddress("0xcabE4d50Fe44adc481FE965ecfc1B0B9a4389640")

        assertThrows<EmptyAddressError> {
            ValidateUtil.validateAddress("")
        }

        assertThrows<InvalidAddressError> {
            ValidateUtil.validateAddress("0x01")
        }
    }

    @Test
    fun validateTransferValueTest() {
        ValidateUtil.validateTransferValue("1")

        assertThrows<EmptyValueError> {
            ValidateUtil.validateTransferValue("")
        }

        assertThrows<InvalidValueError> {
            ValidateUtil.validateTransferValue("qwerty")
        }
    }

    @Test
    fun validateAppIdTest() {
        ValidateUtil.validateAppId("io.usoamic.app")

        assertThrows<EmptyAppIdError> {
            ValidateUtil.validateAppId("")
        }
    }

    @Test
    fun validatePurchaseIdTest() {
        ValidateUtil.validatePurchaseId("io.usoamic.app.purchase1")

        assertThrows<EmptyPurchaseIdError> {
            ValidateUtil.validatePurchaseId("")
        }
    }

    @Test
    fun validateIdTest() {
        ValidateUtil.validateId("1")

        assertThrows<InvalidIdError> {
            ValidateUtil.validateId("")
        }

        assertThrows<InvalidIdError> {
            ValidateUtil.validateId("-1")
        }
    }
}