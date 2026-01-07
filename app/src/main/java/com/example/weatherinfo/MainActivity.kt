package com.example.weatherinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherinfo.data.model.dto.Weather
import com.example.weatherinfo.ui.screen.WeatherRoute
import com.example.weatherinfo.ui.screen.WeatherScreen
import com.example.weatherinfo.ui.theme.WeatherINFOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherINFOTheme {
                        WeatherRoute()
            }
        }
    }
}

