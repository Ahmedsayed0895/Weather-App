package com.example.weatherapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class HourlyWeatherUnits(
    val time: String,
    @SerialName("temperature_2m") val temperature2m: String
)
