package com.claudiu.sonix

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ClockPanel(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {

    private val timeText: TextView
    private val dateText: TextView
    private val daylightText: TextView
    private val sunriseTime = "6:08 AM"
    private val sunsetTime = "7:55 PM"

    init {
        orientation = VERTICAL
        inflate(context, R.layout.panel_clock, this)

        timeText = findViewById(R.id.clockTime)
        dateText = findViewById(R.id.clockDate)
        daylightText = findViewById(R.id.daylightText)

        updateClock()
        drawDaylightArc()
    }

    private fun updateClock() {
        val now = Calendar.getInstance()

        val timeFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
        val dateFormat = SimpleDateFormat("EEEE, MMMM d", Locale.getDefault())

        timeText.text = timeFormat.format(now.time)
        dateText.text = dateFormat.format(now.time)

        daylightText.text = "Daylight: 13h 47m"
    }

    private fun drawDaylightArc() {
        val arcView = findViewById<View>(R.id.daylightArc)
        arcView.background = DaylightArcDrawable()
    }

    inner class DaylightArcDrawable : Drawable() {

        private val paintArc = Paint().apply {
            color = Color.parseColor("#4DA3FF")
            strokeWidth = 12f
            style = Paint.Style.STROKE
            isAntiAlias = true
        }

        private val paintSun = Paint().apply {
            color = Color.parseColor("#FFD65C")
            style = Paint.Style.FILL
            isAntiAlias = true
        }

        override fun draw(canvas: Canvas) {
            val width = bounds.width().toFloat()
            val height = bounds.height().toFloat()

            val arcRect = RectF(0f, height / 2, width, height)

            // Draw arc
            canvas.drawArc(arcRect, 180f, 180f, false, paintArc)

            // Draw sun position (static for now)
            val sunX = width * 0.75f
            val sunY = height * 0.5f
            canvas.drawCircle(sunX, sunY, 18f, paintSun)
        }

        override fun setAlpha(alpha: Int) {}
        override fun setColorFilter(colorFilter: ColorFilter?) {}
        override fun getOpacity(): Int = PixelFormat.TRANSLUCENT
    }
}
