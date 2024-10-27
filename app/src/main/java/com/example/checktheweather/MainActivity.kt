package com.example.checktheweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                    //WeatherOfCity(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CheckTheWeather(modifier: Modifier = Modifier) {
    var isVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF333333))
            .padding(16.dp),
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

            Button(onClick = { isVisible = true }, modifier = modifier.wrapContentWidth()) {
                Text(text = "Search")
            }
        }
        if (isVisible) {
            WeatherOfCity(modifier = modifier)
        }
        Text(
            text = stringResource(R.string.created_by),
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

@Composable
fun WeatherOfCity(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .background(color = Color(color = 0xDD222222))
                .padding(all = (16 * 1.25).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Example, EX",
                textAlign = TextAlign.Right,
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = colorResource(id = R.color.white)
            )
            Row {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Temperature", modifier = Modifier.padding(bottom = 8.dp), fontSize = 24.sp, color = colorResource(id = R.color.white))
                    Text(text = "33.61 °C", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.white))
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Wind", modifier = Modifier.padding(bottom = 8.dp), fontSize = 24.sp, color = colorResource(id = R.color.white))
                    Text(text = "99.9 km/h", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.white))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckTheWeatherPreview() {
    CheckTheWeatherTheme {
        CheckTheWeather()
    }
}