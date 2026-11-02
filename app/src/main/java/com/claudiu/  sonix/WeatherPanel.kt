package com.claudiu.sonix

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*

class WeatherPanel(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {

    private val conditionText: TextView
    private val temperatureText: TextView
    private val feelsLikeText: TextView
    private val locationText: TextView

    private val day1Icon: ImageView
    private val day2Icon: ImageView
    private val day3Icon: ImageView
    private val day4Icon: ImageView
    private val day5Icon: ImageView

    private val day1Text: TextView
    private val day2Text: TextView
    private val day3Text: TextView
    private val day4Text: TextView
    private val day5Text: TextView

    init {
        orientation = VERTICAL
        inflate(context, R.layout.panel_weather, this)

        conditionText = findViewById(R.id.weatherCondition)
        temperatureText = findViewById(R.id.weatherTemperature)
        feelsLikeText = findViewById(R.id.weatherFeelsLike)
        locationText = findViewById(R.id.weatherLocation)

        day1Icon = findViewById(R.id.day1Icon)
        day2Icon = findViewById(R.id.day2Icon)
        day3Icon = findViewById(R.id.day3Icon)
        day4Icon = findViewById(R.id.day4Icon)
        day5Icon = findViewById(R.id.day5Icon)

        day1Text = findViewById(R.id.day1Text)
        day2Text = findViewById(R.id.day2Text)
        day3Text = findViewById(R.id.day3Text)
        day4Text = findViewById(R.id.day4Text)
        day5Text = findViewById(R.id.day5Text)

        loadMockWeather()
    }

    private fun loadMockWeather() {
        // Replace with real API later
        conditionText.text = "Partly Cloudy"
        temperatureText.text = "14°"
        feelsLikeText.text = "Feels like 12°"
        locationText.text = "London"

        // Realistic icons (you will place PNG/SVG in drawable/)
        day1Icon.setImageResource(R.drawable.ic_weather_sun)
        day2Icon.setImageResource(R.drawable.ic_weather_partlycloud)
        day3Icon.setImageResource(R.drawable.ic_weather_rain)
        day4Icon.setImageResource(R.drawable.ic_weather_cloud)
        day5Icon.setImageResource(R.drawable.ic_weather_suncloud)

        day1Text.text = "Wed 19° / 10°"
        day2Text.text = "Thu 17° / 9°"
        day3Text.text = "Fri 16° / 8°"
        day4Text.text = "Sat 15° / 7°"
        day5Text.text = "Sun 18° / 11°"
    }
}
