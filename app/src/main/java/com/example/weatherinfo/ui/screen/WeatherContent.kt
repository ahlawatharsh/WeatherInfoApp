package com.example.weatherinfo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherinfo.ui.UIModel

@Composable
fun WeatherContent(
    uiModel: UIModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(weatherBackground(uiModel.description))
    ) {

        // 🌡 Center content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // City
            Text(
                text = uiModel.cityName,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Weather icon
            AsyncImage(
                model = uiModel.icon,
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 🌡 BIG temperature
            Text(
                text = uiModel.temperature,
                fontSize = 96.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = uiModel.description,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White.copy(alpha = 0.9f)
            )
        }

        WeatherBottomCard(
            modifier = Modifier.align(Alignment.BottomCenter),
            uiModel = uiModel
        )
    }
}

@Composable
fun weatherBackground(description: String): Brush {
    return when {
        description.contains("rain", true) ->
            Brush.verticalGradient(
                listOf(Color(0xFF4A6FA5), Color(0xFF2C3E50))
            )

        description.contains("cloud", true) ->
            Brush.verticalGradient(
                listOf(Color(0xFF90A4AE), Color(0xFF607D8B))
            )

        description.contains("clear", true) ->
            Brush.verticalGradient(
                listOf(Color(0xFF4FC3F7), Color(0xFF0288D1))
            )

        else ->
            Brush.verticalGradient(
                listOf(Color(0xFF81D4FA), Color(0xFF0288D1))
            )
    }
}

@Composable
fun WeatherBottomCard(
    modifier: Modifier = Modifier,
    uiModel: UIModel
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(32.dp),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomWeatherItem("Humidity", uiModel.humidity)
            BottomWeatherItem("Wind", uiModel.windSpeed)
        }
    }
}

@Composable
fun BottomWeatherItem(
    label: String,
    value: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
