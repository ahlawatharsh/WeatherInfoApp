package com.example.weatherinfo.data.repository

import com.example.weatherinfo.data.model.mapper.toDomain
import com.example.weatherinfo.data.network.WeatherApi
import com.example.weatherinfo.domain.model.WeatherDomain

class WeatherRepository (val api: WeatherApi){
    suspend fun getWeather(city: String): WeatherDomain {
        val response = api.getWeather(city)
        return response.toDomain()
    }
}