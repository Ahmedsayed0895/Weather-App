package com.example.weatherapp.ui.composabale

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.urbanist


@Composable
 fun DailyDegreeRow(
    modifier: Modifier = Modifier,
    day:String,
    icon: Painter,
    maxDegree:String,
    minDegree:String,

    ) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween


    ) {
        Text(
            text = day,
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
        ) {
            Image(
                painter =icon,
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
                text = maxDegree,
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
                text = minDegree,
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
