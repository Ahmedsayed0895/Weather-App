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
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


@Composable
fun WeatherAppMainScreen(
    viewModel: WeatherViewModel = getKoin().get()
) {
    val state by viewModel.state.collectAsState()
    WeatherAppMainContent(
        state = state,
    )


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun WeatherAppMainContent(
    state: WeatherState,
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
                    maxDegree = state.maxTemperature,
                    minDegree = state.minTemperature,
                    description = state.weatherDescription,
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
                        value = "${state.windSpeed} KM/h",
                        title = "Wind"

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    WeatherInfoBox(
                        modifier = Modifier.weight(1f),
                        icon = painterResource(id = R.drawable.humidity),
                        value = "${state.humidity}%",
                        title = "Humidity"

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    WeatherInfoBox(
                        modifier = Modifier.weight(1f),
                        icon = painterResource(id = R.drawable.rain),
                        value = "${state.rain}%",
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
                        value = "${state.uvIndex}",
                        title = "UV Index"

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    WeatherInfoBox(
                        modifier = Modifier.weight(1f),
                        icon = painterResource(id = R.drawable.arrow_down),
                        value = "${state.pressure} hPa",
                        title = "Pressure"

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    WeatherInfoBox(
                        modifier = Modifier.weight(1f),
                        icon = painterResource(id = R.drawable.temperature),
                        value = "${state.apparentTemperature} °C",
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
                        items(state.hourlyWeather.size){index->


                            HourlyWeatherBox(
                                icon = painterResource(id = R.drawable.mainly_clear),
                                degree = "${state.hourlyWeather[index]}°C",
                                hour = state.hourlyTime[index].substringAfter("T")
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
                            for (i in 0..<state.dailyTime.size){
                                DailyDegreeRow(
                                    day = getDayNameByDate(state.dailyTime[i]),
                                    icon = painterResource(id = R.drawable.mainly_clear),
                                    maxDegree = "${state.dailyMaxDegree[i]}°C",
                                    minDegree = "${state.dailyMinDegree[i]}°C",
                                )

                            }

                        }
                    }
                }
            }

        }
    }
private fun getDayNameByDate(date: String):String{
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val parsedDate = LocalDate.parse(date,formatter)
    return parsedDate.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
}