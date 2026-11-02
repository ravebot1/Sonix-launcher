package com.claudiu.sonix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.claudiu.sonix.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMenu()
        loadAboutSection()
    }

    private fun setupMenu() {
        binding.menuGeneral.setOnClickListener { showMessage("General settings coming soon") }
        binding.menuDisplay.setOnClickListener { showMessage("Display settings coming soon") }
        binding.menuClockWeather.setOnClickListener { showMessage("Clock & Weather settings coming soon") }
        binding.menuWallpaperThemes.setOnClickListener { showMessage("Wallpaper & Themes coming soon") }
        binding.menuAboutSonix.setOnClickListener { loadAboutSection() }
    }

    private fun loadAboutSection() {
        binding.settingsTitle.text = "About Sonix"
        binding.settingsContent.text =
            "Sonix Launcher\n" +
            "Version: 1.0 (Beta)\n" +
            "Created by: Claudiu\n" +
            "Contact: ravebot@gmail.com\n\n" +
            "Designed and built by Claudiu – London, UK"
        binding.settingsLogo.setImageResource(R.drawable.sonix_logo)
    }

    private fun showMessage(msg: String) {
        binding.settingsContent.text = msg
    }
}
