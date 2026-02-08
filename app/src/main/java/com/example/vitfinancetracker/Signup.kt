package com.example.vitfinancetracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val strengthIndicator = findViewById<TextView>(R.id.passwordStrengthIndicator)
        val sessionManager = AuthSessionManager(this)

        passwordInput.setOnFocusChangeListener { _, _ ->
            updatePasswordStrength(strengthIndicator, passwordInput.text.toString())
        }

        signUpButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            when {
                !InputValidator.isValidEmail(email) -> emailInput.error = getString(R.string.invalid_email)
                !InputValidator.isStrongPassword(password) -> {
                    passwordInput.error = getString(R.string.weak_password_error)
                    updatePasswordStrength(strengthIndicator, password)
                }
                else -> {
                    sessionManager.saveSession(email)
                    Toast.makeText(this, getString(R.string.signup_success), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finishAffinity()
                }
            }
        }
    }

    private fun updatePasswordStrength(indicator: TextView, password: String) {
        val strengthText = when (InputValidator.passwordStrengthScore(password)) {
            in 0..2 -> getString(R.string.password_strength_weak)
            3, 4 -> getString(R.string.password_strength_medium)
            else -> getString(R.string.password_strength_strong)
        }
        val colorRes = when (strengthText) {
            getString(R.string.password_strength_strong) -> android.R.color.holo_green_dark
            getString(R.string.password_strength_medium) -> android.R.color.holo_orange_dark
            else -> android.R.color.holo_red_dark
        }
        indicator.text = strengthText
        indicator.setTextColor(ContextCompat.getColor(this, colorRes))
    }
}
