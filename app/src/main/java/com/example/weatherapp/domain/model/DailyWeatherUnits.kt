package com.example.weatherapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DailyWeatherUnits(
    val time: String,
    @SerialName("temperature_2m_max") val temperature2mMax: String,
    @SerialName("temperature_2m_min") val temperature2mMin: String
)