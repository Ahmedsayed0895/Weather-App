package com.example.weatherapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse (
    val longitude: Double,
    val latitude: Double,
    @SerialName("generationtime_ms") val generationTime: Double,
    @SerialName("utc_offset_seconds") val utcOffsetSeconds: Int,
    val timezone:String,
    @SerialName("timezone_abbreviation") val timezoneAbbreviation: String,
    val elevation: Double,
    @SerialName("current_units") val currentWeatherUnits: CurrentWeatherUnits,
    @SerialName("current") val currentWeather: CurrentWeather,
    @SerialName("hourly_units") val hourlyWeatherUnits: HourlyWeatherUnits,
    @SerialName("hourly") val hourlyWeather: HourlyWeather,
    @SerialName("daily_units") val dailyWeatherUnits: DailyWeatherUnits,
    @SerialName("daily") val dailyWeather: DailyWeather

)




