package com.example.weatherinfo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherinfo.data.network.RetrofitInstance
import com.example.weatherinfo.data.repository.WeatherRepository
import com.example.weatherinfo.domain.mapper.toUiModel
import com.example.weatherinfo.ui.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(): ViewModel() {
    private val repository = WeatherRepository(RetrofitInstance.api)
    private val _uistate = MutableStateFlow<WeatherUiState>(WeatherUiState.Idle)
    val uiState: StateFlow<WeatherUiState> = _uistate

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    fun onQueryChange(text: String) {
        _query.value = text
    }

    fun searchWeather() {
        loadWeather(_query.value)
    }

    fun loadWeather(city:String){
        viewModelScope.launch {
            _uistate.value = WeatherUiState.Loading

            try {
                val weather = repository.getWeather(city)
                val uiModel = weather.toUiModel()

                _uistate.value = WeatherUiState.Success(uiModel)
            }catch (e: Exception){
                _uistate.value  = WeatherUiState.Error("Unable to load weather")
            }
        }
    }

}