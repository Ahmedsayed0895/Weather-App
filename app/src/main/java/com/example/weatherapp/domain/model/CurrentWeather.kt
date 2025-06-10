package com.example.weatherapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CurrentWeather(
    val time: String,
    val interval: Int,
    @SerialName("temperature_2m") val temperature2m: Double,
    @SerialName("relative_humidity_2m") val relativeHumidity2m: Int,
    @SerialName("apparent_temperature") val apparentTemperature: Double,
    @SerialName("is_day") val isDay: Int,
    val precipitation: Double,
    val rain: Double,
    @SerialName("weather_code") val weatherCode: Int,
    @SerialName("pressure_msl") val pressureMsl: Double,
    @SerialName("surface_pressure") val surfacePressure: Double,
    @SerialName("wind_speed_10m") val windSpeed10m: Double
)
