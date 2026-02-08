package com.example.vitfinancetracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val sessionManager = AuthSessionManager(this)
        if (!sessionManager.isLoggedIn()) {
            startActivity(Intent(this, Selection_Screen::class.java))
            finish()
            return
        }

        val email = sessionManager.getUserEmail().orEmpty()
        findViewById<TextView>(R.id.greetingText).text = getString(R.string.welcome_user, email)
        findViewById<TextView>(R.id.monthlyBudgetText).text = getString(
            R.string.budget_summary,
            LocalDate.now().month.name.lowercase().replaceFirstChar { it.uppercase() },
            12000,
            8750,
            3250
        )
        findViewById<TextView>(R.id.financeInsightText).text = getFinanceInsight(3250)

        findViewById<Button>(R.id.logoutButton).setOnClickListener {
            sessionManager.clearSession()
            startActivity(Intent(this, Selection_Screen::class.java))
            finishAffinity()
        }
    }

    private fun getFinanceInsight(remainingAmount: Int): String {
        return if (remainingAmount > 3000) {
            getString(R.string.insight_healthy)
        } else {
            getString(R.string.insight_reduce_spend)
        }
    }
}
