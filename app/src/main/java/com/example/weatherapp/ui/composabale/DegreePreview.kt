package com.example.weatherapp.ui.composabale

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.urbanist


@Composable
 fun DegreePreview(
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
