package com.example.weatherapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.urbanist


@Composable
fun HourlyWeatherBox(
    modifier: Modifier = Modifier,
    icon: Painter,
    degree:String,
    hour:String,

    ) {
    Box(
        modifier = modifier
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


            contentAlignment = Center

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
                    text = degree,
                    fontFamily = urbanist,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = Color(0xDE060414),
                )
                Text(
                    text = hour,
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


            contentAlignment = Center

        ) {

            Image(

                painter = icon,
                contentDescription = "sun icon",
            )
        }
    }
}