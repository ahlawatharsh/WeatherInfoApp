package com.example.weatherinfo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.weatherinfo.ui.UIModel
import com.example.weatherinfo.ui.WeatherUiState
import com.example.weatherinfo.ui.viewmodel.WeatherViewModel

@Composable
fun WeatherRoute() {
    val viewModel: WeatherViewModel = viewModel()
    val query by viewModel.query.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold() { innerPadding->
        WeatherScreen(
            modifier = Modifier.padding(innerPadding).systemBarsPadding(),
            query = query,
            onQueryChange = viewModel::onQueryChange,
            onSearchClick = viewModel::searchWeather,
            uiState = uiState
        )
    }
}
