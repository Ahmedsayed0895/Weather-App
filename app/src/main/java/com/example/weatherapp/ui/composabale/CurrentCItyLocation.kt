package com.example.weatherapp.ui.composabale

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R


@Composable
fun CurrentCItyLocation(city: String) {
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
