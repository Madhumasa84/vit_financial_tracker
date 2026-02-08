package com.example.vitfinancetracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Selection_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selection_screen)

        findViewById<Button>(R.id.buttonSignup).setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }
        findViewById<Button>(R.id.buttonSignin).setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }
}
