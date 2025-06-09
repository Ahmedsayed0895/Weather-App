package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.DayPrimary
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.ui.theme.urbanist

class MainActivity : ComponentActivity() {
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
                            Spacer(modifier = Modifier.height(6.dp))


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
                                    color = Color(0xFF060414),

                                    )
                                Spacer(modifier = Modifier.height(24.dp))
                                LazyRow (
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)

                                ){
                                    items (count = 5){


                                        Box (
                                            modifier = Modifier

                                                .height(132.dp),
                                            contentAlignment = BottomCenter


                                                ) {

                                            Box(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(20.dp))
                                                    .width(88.dp)
                                                    .height(120.dp)
                                                    .background(Color(0xB3FFFFFF))

                                                    .border(
                                                        width = 1.dp,
                                                        color = Color(0x14060414),
                                                        shape = RoundedCornerShape(20.dp)
                                                    ),


                                                contentAlignment = Alignment.Center

                                            ) {


                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxSize(),

                                                    horizontalAlignment = CenterHorizontally
                                                ) {
                                                    Box(
                                                        modifier = Modifier
                                                            .height(64.dp)
                                                            .fillMaxWidth()
                                                            .shadow(
                                                                elevation = 14.dp,
                                                                shape = CircleShape,
                                                                spotColor = Color(0x421D2646),

                                                                ),

                                                    )
                                                    Text(
                                                        text = "25°C",
                                                        fontFamily = urbanist,
                                                        fontSize = 16.sp,
                                                        fontWeight = FontWeight.W500,
                                                        color = Color(0xDE060414),
                                                    )
                                                    Text(
                                                        text = "11:00",
                                                        fontFamily = urbanist,
                                                        fontSize = 16.sp,
                                                        fontWeight = FontWeight.W500,
                                                        color = Color(0x99060414),
                                                    )
                                                }

                                            }
                                            Box(
                                                modifier = Modifier
                                                    .width(64.dp)
                                                    .height(58.dp)
                                                    .align(Alignment.TopCenter),


                                                contentAlignment = Alignment.Center

                                            ) {

                                                Image(

                                                    painter = painterResource(id = R.drawable.mainly_clear),
                                                    contentDescription = "sun icon",
                                                )
                                            }
                                        }

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
                                    Column () {
                                        for (i in 1..7){
                                            Row (
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(horizontal = 16.dp,vertical = 8.dp),
                                                verticalAlignment = CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween


                                            ){
                                                Text(
                                                    text = "Monday",
                                                    fontFamily = urbanist,
                                                    fontSize = 16.sp,
                                                    fontWeight = FontWeight.W400,
                                                    color = Color(0x99060414),
                                                    modifier = Modifier.width(91.dp)

                                                )
                                                Box(
                                                    modifier = Modifier
                                                        .width(91.dp)
                                                        .height(45.dp),
                                                    contentAlignment = Center
                                                ){
                                                    Image(
                                                        painter = painterResource(id = R.drawable.mainly_clear),
                                                        contentDescription = "sun icon",
                                                    )
                                                }
                                                Row(
                                                    verticalAlignment = CenterVertically,
                                                ) {
                                                    Icon(
                                                        painter = painterResource(R.drawable.arrow_up),
                                                        contentDescription = "arrow up icon",
                                                        tint = Color(0xDE060414)
                                                    )

                                                    Text(
                                                        text = "32°C",
                                                        fontFamily = urbanist,
                                                        fontSize = 16.sp,
                                                        fontWeight = FontWeight.W500,
                                                        color = Color(0xDE060414),
                                                    )

                                                    VerticalDivider(
                                                        thickness = 1.dp,
                                                        color = Color(0x3D060414),
                                                        modifier = Modifier
                                                            .height(14.dp)
                                                            .padding(horizontal = 8.dp)

                                                    )

                                                    Icon(
                                                        painter = painterResource(R.drawable.arrow_downn),
                                                        contentDescription = "arrow up icon",
                                                        tint = Color(0xDE060414),

                                                        )

                                                    Text(
                                                        text = "20°C",
                                                        fontFamily = urbanist,
                                                        fontSize = 16.sp,
                                                        fontWeight = FontWeight.W500,
                                                        color = Color(0xDE060414),
                                                    )

                                                }


                                            }
                                            HorizontalDivider(
                                                thickness = 1.dp,
                                                color = Color(0x14060414),

                                            )

                                        }

                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    @Composable
    private fun WeatherInfoBox(
        modifier: Modifier = Modifier,
        icon:Painter,
        value:String,
        title:String,
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
                    painter = icon,
                    contentDescription = icon.toString(),
                    tint = DayPrimary

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = value,
                    fontFamily = urbanist,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    color = Color(0xDE060414),
                )
                Text(
                    text = title,
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
                        contentDescription = "arrow up icon",
                        tint = Color(0x99060414)
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
                        contentDescription = "arrow up icon",
                        tint = Color(0x99060414),

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
                tint = Color(0xFF323232)

                )
            Text(
                text = city,
                modifier = Modifier.padding(
                    vertical = 2.dp,
                    horizontal = 4.dp
                ),
                color = Color(0xFF323232),
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