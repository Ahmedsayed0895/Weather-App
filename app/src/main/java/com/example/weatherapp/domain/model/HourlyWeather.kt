package com.example.weatherapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class HourlyWeather(
    val time: List<String>,
    @SerialName("temperature_2m") val temperature2m: List<Double>
)