package com.sonix

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.ContextCompat

object ThemeManager {

    private const val PREFS_NAME = "sonix_theme_prefs"
    private const val KEY_THEME = "selected_theme"

    enum class Theme {
        DEFAULT,
        DARK,
        NEON
    }

    fun applyTheme(activity: Activity, theme: Theme) {
        saveTheme(activity, theme)

        when (theme) {
            Theme.DEFAULT -> {
                activity.window.decorView.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.sonix_background)
                )
            }

            Theme.DARK -> {
                activity.window.decorView.setBackgroundColor(
                    ContextCompat.getColor(activity, android.R.color.black)
                )
            }

            Theme.NEON -> {
                activity.window.decorView.setBackgroundColor(
                    ContextCompat.getColor(activity, R.color.sonix_neon_background)
                )
            }
        }
    }

    fun getSavedTheme(context: Context): Theme {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val saved = prefs.getString(KEY_THEME, Theme.DEFAULT.name)
        return Theme.valueOf(saved!!)
    }

    private fun saveTheme(context: Context, theme: Theme) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_THEME, theme.name).apply()
    }
}
