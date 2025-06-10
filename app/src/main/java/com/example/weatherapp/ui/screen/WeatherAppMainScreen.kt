package com.example.weatherapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.DailyWeather
import com.example.weatherapp.domain.model.HourlyWeather
import com.example.weatherapp.ui.composable.CurrentCItyLocation
import com.example.weatherapp.ui.composable.DailyDegreeRow
import com.example.weatherapp.ui.composable.DegreePreview
import com.example.weatherapp.ui.composable.HourlyWeatherBox
import com.example.weatherapp.ui.composable.WeatherInfoBox
import com.example.weatherapp.ui.theme.DayPrimary
import com.example.weatherapp.ui.theme.urbanist
import com.example.weatherapp.ui.viewModel.WeatherViewModel
import com.example.weatherapp.ui.viewModel.state.WeatherState
import org.koin.java.KoinJavaComponent.getKoin


@Composable
fun WeatherAppMainScreen(
    viewModel: WeatherViewModel = getKoin().get()
) {
    val state by viewModel.state.collectAsState()
    WeatherAppMainContent(
        state = state,
        onChangeCurrentTemperature = viewModel::onCurrentTemperatureChange,
        onChangeWeatherDescription = viewModel::onWeatherDescriptionChange,
        onChangeWindSpeed = viewModel::onWindSpeedChange,
        onChangeRain = viewModel::onRainChange,
        onChangePressure = viewModel::onPressureChange ,
        onChangeHumidity = viewModel::onHumidityChange,
        onChangeUvIndex = viewModel::onUvIndexChange,
        onChangeHourlyWeather =viewModel::onHourlyWeatherChange ,
        onChangeDailyWeather = viewModel::onDailyWeatherChange,
        onChangeMaxTemperature = viewModel::onMaxTemperatureChange,
        onChangeMinTemperature = viewModel::onMinTemperatureChange,

    )


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun WeatherAppMainContent(
    state: WeatherState,
    onChangeCurrentTemperature: (Int) -> Unit,
    onChangeWeatherDescription: (String) -> Unit,
    onChangeWindSpeed: (Int) -> Unit,
    onChangeRain: (Int) -> Unit,
    onChangePressure: (Int) -> Unit,
    onChangeHumidity: (Int) -> Unit,
    onChangeUvIndex: (Int) -> Unit,
    onChangeHourlyWeather: (List<HourlyWeather>) -> Unit,
    onChangeDailyWeather: (List<DailyWeather>) -> Unit,
    onChangeMaxTemperature: (Int) -> Unit,
    onChangeMinTemperature: (Int) -> Unit,

    ){

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            DayPrimary,
                            Color.White
                        ),
                    ),
                ),
            horizontalAlignment = CenterHorizontally,
            contentPadding = PaddingValues(
                top =  WindowInsets.systemBars.asPaddingValues().calculateTopPadding(),
                bottom = 32.dp  + WindowInsets.systemBars.asPaddingValues().calculateBottomPadding(),
                start = 12.dp,
                end = 12.dp,
            ),


            ) {
            item {
                CurrentCItyLocation(city= "Baghdad")
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.mainly_clear),
                    contentDescription = "sun icon",
                )
            }

            item {
                DegreePreview(
                    currentDegree = state.currentTemperature,
                    maxDegree = 32,
                    minDegree = 20,
                    description = "Partly cloudy",
                )
            }

            item {
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    WeatherInfoBox(
                        modifier = Modifier.weight(1f),
                        icon = painterResource(id = R.drawable.fast_wind),
                        value = "13 KM/h",
                        title = "Wind"

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    WeatherInfoBox(
                        modifier = Modifier.weight(1f),
                        icon = painterResource(id = R.drawable.humidity),
                        value = "24%",
                        title = "Humidity"

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    WeatherInfoBox(
                        modifier = Modifier.weight(1f),
                        icon = painterResource(id = R.drawable.rain),
                        value = "2%",
                        title = "Rain"

                    )


                }
                Spacer(modifier = Modifier.height(6.dp))
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    WeatherInfoBox(
                        modifier = Modifier.weight(1f),
                        icon = painterResource(id = R.drawable.uv),
                        value = "2",
                        title = "UV Index"

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    WeatherInfoBox(
                        modifier = Modifier.weight(1f),
                        icon = painterResource(id = R.drawable.arrow_down),
                        value = "1012 hPa",
                        title = "Pressure"

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    WeatherInfoBox(
                        modifier = Modifier.weight(1f),
                        icon = painterResource(id = R.drawable.temperature),
                        value = "22°C",
                        title = "Feels like"

                    )


                }


            }
            item {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    horizontalAlignment = Alignment.Start

                )
                {
                    Text(
                        text = "Today",
                        fontFamily = urbanist,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600,
                        lineHeight = 20.sp,
                        color = Color(0xFF060414),

                        )
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)

                    ){
                        items (count = 5){


                            HourlyWeatherBox(
                                icon = painterResource(id = R.drawable.mainly_clear),
                                degree = "24°C",
                                hour = "10:00"
                            )

                        }


                    }
                }


            }
            item {
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.Start
                )
                {
                    Text(
                        text = "Next 7 days",
                        fontFamily = urbanist,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600,
                        color = Color(0xFF060414),

                        )
                    Spacer(modifier = Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(24.dp))
                            .background(Color(0xB3FFFFFF))
                            .border(
                                width = 1.dp,
                                color = Color(0x14060414),
                                shape = RoundedCornerShape(24.dp)
                            )

                    ){
                        Column  {
                            for (i in 1..7){
                                DailyDegreeRow(
                                    day = "Monday",
                                    icon = painterResource(id = R.drawable.mainly_clear),
                                    maxDegree = "32°C",
                                    minDegree = "20°C",
                                )

                            }

                        }
                    }
                }
            }

        }
    }
