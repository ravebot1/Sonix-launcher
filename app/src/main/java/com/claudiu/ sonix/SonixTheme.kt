package com.claudiu.sonix

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.BlurMaskFilter
import android.widget.TextView

object SonixTheme {

    // Neon glow intensity (you can expose this in Settings later)
    var glowIntensity = 18f

    // Main neon color
    val neonColor = Color.parseColor("#4DA3FF")

    // Background color
    val backgroundColor = Color.parseColor("#0A0A0A")

    // Accent color
    val accentColor = Color.parseColor("#7BC9FF")

    // Apply neon glow to any TextView
    fun applyNeonGlow(textView: TextView) {
        val paint = Paint()
        paint.color = neonColor
        paint.maskFilter = BlurMaskFilter(glowIntensity, BlurMaskFilter.Blur.NORMAL)
        textView.setLayerType(TextView.LAYER_TYPE_SOFTWARE, paint)
        textView.setTextColor(neonColor)
    }

    // Apply default Sonix text style
    fun applyDefaultText(textView: TextView) {
        textView.setTextColor(Color.WHITE)
        textView.textSize = 18f
    }

    // Apply title style (used in Settings)
    fun applyTitleText(textView: TextView) {
        textView.setTextColor(Color.WHITE)
        textView.textSize = 28f
    }

    // Future: dynamic theme switching
    fun setGlowIntensity(value: Float) {
        glowIntensity = value
    }

    fun setAccentColor(hex: String) {
        // Example: "#FFAA33"
        try {
            val color = Color.parseColor(hex)
            // You can store this for future use
        } catch (_: Exception) { }
    }
}
