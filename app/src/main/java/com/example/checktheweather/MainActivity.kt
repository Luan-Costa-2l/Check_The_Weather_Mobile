package com.example.checktheweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Clima")
        Row {
            EditCityName()
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Search")
            }
        }
        Text(text = "Created by Luan Cordeiro")
    }
}

@Composable
fun EditCityName() {
    var cityName by remember { mutableStateOf("") }

    OutlinedTextField(
        value = cityName,
        onValueChange = { cityName = it },
        label = { Text(text = "Write the city's name") }
    )
}

@Preview(showBackground = true)
@Composable
fun CheckTheWeatherPreview() {
    CheckTheWeatherTheme {
        CheckTheWeather()
    }
}