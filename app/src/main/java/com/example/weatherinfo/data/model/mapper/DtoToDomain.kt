package com.example.weatherinfo.data.model.mapper

import com.example.weatherinfo.data.model.dto.WeatherResponse
import com.example.weatherinfo.domain.model.WeatherDomain

fun WeatherResponse.toDomain(): WeatherDomain {
    return WeatherDomain(
        cityName = name,
        temperature = main.temp,
        description = weather.firstOrNull()?.description ?: "",
        icon = weather.firstOrNull()?.icon ?: "",
        humidity = main.humidity,
        windSpeed = wind.speed
    )
}
