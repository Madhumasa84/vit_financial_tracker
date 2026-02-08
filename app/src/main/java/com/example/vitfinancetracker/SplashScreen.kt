package com.example.vitfinancetracker

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        val sessionManager = AuthSessionManager(this)
        Handler(Looper.getMainLooper()).postDelayed({
            val destination = if (sessionManager.isLoggedIn()) {
                MainActivity::class.java
            } else {
                Selection_Screen::class.java
            }
            startActivity(Intent(this, destination))
            finish()
        }, 1500)
    }
}
