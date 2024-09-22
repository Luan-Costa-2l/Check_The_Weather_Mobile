package com.example.checktheweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.checktheweather.ui.theme.CheckTheWeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckTheWeatherTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckTheWeather(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CheckTheWeather(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().background(color = Color(0xFF333333)).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Clima",
            color = Color(0xFFFFFFFF),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            EditCityName(modifier = Modifier.weight(1f))

            Spacer(modifier = modifier.width(16.dp))

            Button(onClick = { /*TODO*/ }, modifier = modifier.wrapContentWidth()) {
                Text(text = "Search")
            }
        }
        Text(
            text = "Created by Luan Cordeiro",
            color = Color(0xFFFFFFFF),
            modifier = modifier
                .padding(top = 16.dp)
        )
    }
}

@Composable
fun EditCityName(modifier: Modifier = Modifier) {
    var cityName by remember { mutableStateOf("") }

    TextField(
        value = cityName,
        onValueChange = { cityName = it },
        label = { Text(text = "Write the city's name") },
        modifier = modifier,
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun CheckTheWeatherPreview() {
    CheckTheWeatherTheme {
        CheckTheWeather()
    }
}