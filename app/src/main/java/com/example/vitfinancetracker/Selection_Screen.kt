package com.example.vitfinancetracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Selection_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selection_screen)
        val but1 = findViewById<Button>(R.id.button)
        val but2 = findViewById<Button>(R.id.button2)
        but1.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
        but2.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }
    }
}