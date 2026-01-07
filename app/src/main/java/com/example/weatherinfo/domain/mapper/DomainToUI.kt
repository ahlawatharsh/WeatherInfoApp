package com.example.weatherinfo.domain.mapper

import androidx.compose.ui.text.capitalize
import com.example.weatherinfo.domain.model.WeatherDomain
import com.example.weatherinfo.ui.UIModel

fun WeatherDomain.toUiModel(): UIModel{
    return UIModel(
        cityName = cityName,
        temperature = "${temperature.toInt()}°C",
        description = description.capitalize(),
        icon = "https://openweathermap.org/img/wn/$icon@2x.png",
        humidity = "${humidity.toString()}%",
        windSpeed = "${windSpeed.toString()} m/s"
    )
}