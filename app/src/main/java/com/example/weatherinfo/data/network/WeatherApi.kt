package com.example.weatherinfo.data.network

import com.example.weatherinfo.data.model.dto.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q")city: String,
        @Query("units") units: String = "metric",
        @Query("appid")apikey:String = "YOUR_WEATHER_API_KEY"
    ): WeatherResponse
}