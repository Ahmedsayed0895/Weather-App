package com.example.weatherapp.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.DayPrimary
import com.example.weatherapp.ui.theme.urbanist

@Composable
 fun WeatherInfoBox(
    modifier: Modifier = Modifier,
    icon: Painter,
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