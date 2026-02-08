package com.example.vitfinancetracker

import android.content.Context

class AuthSessionManager(context: Context) {
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveSession(email: String) {
        prefs.edit()
            .putBoolean(KEY_IS_LOGGED_IN, true)
            .putString(KEY_EMAIL, email)
            .apply()
    }

    fun clearSession() {
        prefs.edit().clear().apply()
    }

    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGGED_IN, false)

    fun getUserEmail(): String? = prefs.getString(KEY_EMAIL, null)

    companion object {
        private const val PREFS_NAME = "vit_finance_tracker_prefs"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_EMAIL = "email"
    }
}
