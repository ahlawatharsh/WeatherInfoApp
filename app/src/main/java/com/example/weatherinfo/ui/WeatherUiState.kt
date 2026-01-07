package com.example.weatherinfo.ui

import com.example.weatherinfo.domain.model.WeatherDomain

sealed interface WeatherUiState {
    object Idle : WeatherUiState
    object Loading : WeatherUiState
    data class Success(val data: UIModel): WeatherUiState
    data class Error(val message: String): WeatherUiState
}