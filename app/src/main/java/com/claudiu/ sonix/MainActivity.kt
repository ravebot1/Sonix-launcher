package com.claudiu.sonix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.claudiu.sonix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate main layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load clock panel
        loadClockPanel()

        // Load weather panel
        loadWeatherPanel()

        // Load app row
        loadAppRow()

        // Handle settings button
        binding.settingsButton.setOnClickListener {
            openSettings()
        }
    }

    private fun loadClockPanel() {
        // ClockPanel.kt will handle neon clock + sunrise/sunset graphics
        val clockPanel = ClockPanel(this)
        binding.clockContainer.addView(clockPanel)
    }

    private fun loadWeatherPanel() {
        // WeatherPanel.kt will handle realistic weather icons + forecast
        val weatherPanel = WeatherPanel(this)
        binding.weatherContainer.addView(weatherPanel)
    }

    private fun loadAppRow() {
        // Later you can dynamically load installed apps here
        val appRow = AppRow(this)
        binding.appRowContainer.addView(appRow)
    }

    private fun openSettings() {
        val intent = android.content.Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}
