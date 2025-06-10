package com.example.weatherapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CurrentWeatherUnits (
    val time: String,
    val interval: String,
    @SerialName("temperature_2m") val temperature2m: String,
    @SerialName("relative_humidity_2m") val relativeHumidity2m: String,
    @SerialName("apparent_temperature") val apparentTemperature: String,
    @SerialName("is_day") val isDay: String,
    val precipitation: String,
    val rain: String,
    @SerialName("weather_code") val weatherCode: String,
    @SerialName("pressure_msl") val pressureMsl: String,
    @SerialName("surface_pressure") val surfacePressure: String,
    @SerialName("wind_speed_10m") val windSpeed10m: String
)