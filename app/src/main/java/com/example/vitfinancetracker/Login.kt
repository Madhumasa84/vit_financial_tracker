package com.example.vitfinancetracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val signInButton = findViewById<Button>(R.id.signInButton)
        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        val sessionManager = AuthSessionManager(this)

        signInButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            when {
                !InputValidator.isValidEmail(email) -> emailInput.error = getString(R.string.invalid_email)
                password.isEmpty() -> passwordInput.error = getString(R.string.password_required)
                else -> {
                    sessionManager.saveSession(email)
                    Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finishAffinity()
                }
            }
        }

        forgotPassword.setOnClickListener {
            Toast.makeText(this, getString(R.string.reset_password_hint), Toast.LENGTH_SHORT).show()
        }
    }
}
