package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.DayPrimary
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.ui.theme.urbanist

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()

                ) {
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
                        contentPadding = PaddingValues(vertical = 32.dp, horizontal = 12.dp),


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
                                currentDegree = 24,
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
                                WeatherInfoBox(modifier = Modifier.weight(1f))
                                Spacer(modifier = Modifier.width(6.dp))
                                WeatherInfoBox(modifier = Modifier.weight(1f))
                                Spacer(modifier = Modifier.width(6.dp))
                                WeatherInfoBox(modifier = Modifier.weight(1f))


                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ){
                                WeatherInfoBox(modifier = Modifier.weight(1f))
                                Spacer(modifier = Modifier.width(6.dp))
                                WeatherInfoBox(modifier = Modifier.weight(1f))
                                Spacer(modifier = Modifier.width(6.dp))
                                WeatherInfoBox(modifier = Modifier.weight(1f))


                            }

                        }


                    }
                }
            }
        }
    }

    @Composable
    private fun WeatherInfoBox(
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(24.dp))
                .background(Color.White)
                .padding(horizontal = 8.dp, vertical = 16.dp)

        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.fast_wind),
                    contentDescription = "humidity icon",
                    tint = DayPrimary

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "13 KM/h",
                    fontFamily = urbanist,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    color = Color(0xDE060414),
                )
                Text(
                    text = "Wind",
                    fontFamily = urbanist,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0x99060414),
                )

            }

        }
    }

    @Composable
    private fun DegreePreview(
        currentDegree: Int,
        maxDegree: Int,
        minDegree: Int,
        description: String,
    ) {
        Column(
            modifier = Modifier
                .padding(top = 12.dp, bottom = 24.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                text = "$currentDegree°C",
                fontFamily = urbanist,
                fontSize = 64.sp,
                fontWeight = FontWeight.W800,
                color = Color(0xFF060414),
            )
            Text(
                text = description,
                fontFamily = urbanist,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = Color(0x99060414),
            )
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color(0x14060414))
                    .padding(vertical = 8.dp, horizontal = 24.dp)


            ) {
                Row(
                    verticalAlignment = CenterVertically,


                    ) {
                    Icon(
                        painter = painterResource(R.drawable.arrow_up),
                        contentDescription = "arrow up icon"
                    )

                    Text(
                        text = "$maxDegree°C",
                        fontFamily = urbanist,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        color = Color(0x99060414),
                    )

                    VerticalDivider(
                        thickness = 1.dp,
                        color = Color(0x3D060414),
                        modifier = Modifier
                            .height(19.dp)
                            .padding(horizontal = 8.dp)

                    )

                    Icon(
                        painter = painterResource(R.drawable.arrow_downn),
                        contentDescription = "arrow up icon"
                    )

                    Text(
                        text = "$minDegree°C",
                        fontFamily = urbanist,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        color = Color(0x99060414),
                    )

                }

            }
        }
    }

    @Composable
    private fun CurrentCItyLocation(city: String) {
        Row(
            modifier = Modifier
                .padding(top = 24.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "location icon",

                )
            Text(
                text = city,
                modifier = Modifier.padding(
                    vertical = 2.dp,
                    horizontal = 4.dp
                )
            )


        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppTheme {
    }
}