package kz.iitu.activityexample.utils

import android.content.Context
import android.preference.PreferenceManager

object PreferenceUtils {

    private const val PREF_PASSWORD = "pref_password"
    private const val PREF_NAME = "pref_name"
    private const val PREF_AGE = "pref_age"
    private const val PREF_EMAIL = "pref_email"
    private const val PREF_LOGGED = "pref_logged"

    private fun getPreferences(context: Context) = PreferenceManager.getDefaultSharedPreferences(context)

    fun saveLogged(context: Context, isLogged: Boolean) {
        getPreferences(context).edit().putBoolean(PREF_LOGGED, isLogged).apply()
    }

    fun getLogged(context: Context) = getPreferences(context).getBoolean(PREF_LOGGED, false)

    fun saveCurrentEmail(context: Context, email: String) {
        getPreferences(context).edit().putString(PREF_EMAIL, email).apply()
    }

    fun getCurrentEmail(context: Context) = getPreferences(context).getString(PREF_EMAIL, "")

    fun saveEmail(context: Context, email: String) {
        getPreferences(context).edit().putString("${PREF_EMAIL}_$email", email).apply()
    }

    fun getEmail(context: Context, email: String) = getPreferences(context).getString("${PREF_EMAIL}_$email", "")

    fun saveName(context: Context, email: String, name: String) {
        getPreferences(context).edit().putString("${PREF_NAME}_$email", name).apply()
    }

    fun getName(context: Context, email: String) = getPreferences(context).getString("${PREF_NAME}_$email", "")

    fun saveAge(context: Context, email: String, age: Int) {
        getPreferences(context).edit().putInt("${PREF_AGE}_$email", age).apply()
    }

    fun getAge(context: Context, email: String) = getPreferences(context).getInt("${PREF_AGE}_$email", 0)


    fun savePassword(context: Context, email: String, password: String) {
        getPreferences(context).edit().putString("${PREF_PASSWORD}_$email", password).apply()
    }

    fun getPassword(context: Context, email: String) = getPreferences(context).getString("${PREF_PASSWORD}_$email", "")
}