package com.example.vitfinancetracker

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun validEmail_passesValidation() {
        assertTrue(InputValidator.isValidEmail("student@vit.ac.in"))
    }

    @Test
    fun invalidEmail_failsValidation() {
        assertFalse(InputValidator.isValidEmail("student.vit.ac.in"))
    }

    @Test
    fun strongPassword_passesValidation() {
        assertTrue(InputValidator.isStrongPassword("Abcdef@1"))
    }

    @Test
    fun weakPassword_failsValidation() {
        assertFalse(InputValidator.isStrongPassword("abc123"))
    }
}
