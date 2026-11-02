package com.sonix

import android.app.WallpaperManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WallpaperThemesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.panel_wallpaper_themes)

        val wallpaperPreview = findViewById<ImageView>(R.id.wallpaperPreview)
        val changeWallpaperButton = findViewById<TextView>(R.id.changeWallpaperButton)

        val themeDefault = findViewById<ImageView>(R.id.themeDefault)
        val themeDark = findViewById<ImageView>(R.id.themeDark)
        val themeNeon = findViewById<ImageView>(R.id.themeNeon)

        // Load current wallpaper into preview
        val wallpaperManager = WallpaperManager.getInstance(this)
        val wallpaperDrawable = wallpaperManager.drawable
        wallpaperPreview.setImageDrawable(wallpaperDrawable)

        // Change wallpaper (simple demo)
        changeWallpaperButton.setOnClickListener {
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.wallpaper_default)
            wallpaperManager.setBitmap(bitmap)
            wallpaperPreview.setImageBitmap(bitmap)
        }

        // Theme switching (demo logic)
        themeDefault.setOnClickListener {
            ThemeManager.applyTheme(this, ThemeManager.Theme.DEFAULT)
        }

        themeDark.setOnClickListener {
            ThemeManager.applyTheme(this, ThemeManager.Theme.DARK)
        }

        themeNeon.setOnClickListener {
            ThemeManager.applyTheme(this, ThemeManager.Theme.NEON)
        }
    }
}
