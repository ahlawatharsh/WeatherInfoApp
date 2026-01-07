package com.example.weatherinfo.domain.model

data class WeatherDomain(
    val cityName: String,
    val temperature: Double,
    val description: String,
    val icon: String,
    val humidity: Int,
    val windSpeed: Double
)
