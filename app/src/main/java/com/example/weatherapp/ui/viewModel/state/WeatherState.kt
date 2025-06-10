package com.example.weatherapp.ui.viewModel.state

import com.example.weatherapp.domain.model.DailyWeather
import com.example.weatherapp.domain.model.HourlyWeather

data class WeatherState(
    val currentTemperature: Int = 0,
    val weatherDescription: String = "",
    val windSpeed: Int = 0,
    val rain: Int = 0,
    val pressure: Int = 0,
    val humidity: Int = 0,
    val uvIndex: Int = 0,
    val hourlyWeather: List<HourlyWeather> = emptyList(),
    val dailyWeather: List<DailyWeather> = emptyList(),
    val maxTemperature: Int = 0,
    val minTemperature: Int = 0,


)