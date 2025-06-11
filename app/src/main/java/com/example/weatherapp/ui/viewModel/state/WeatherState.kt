package com.example.weatherapp.ui.viewModel.state

data class WeatherState(
    val currentTemperature: Int = 1,
    val weatherDescription: String = "",
    val windSpeed: Int = 0,
    val rain: Int = 0,
    val apparentTemperature: Int = 0,
    val pressure: Int = 0,
    val humidity: Int = 0,
    val uvIndex: Int = 0,
    val hourlyWeather: List<Double> = emptyList(),
    val hourlyTime: List<String> = emptyList(),
    val dailyMaxDegree: List<Int> = emptyList(),
    val dailyMinDegree: List<Int> = emptyList(),
    val dailyTime: List<String> = emptyList(),
    val maxTemperature: Int = 0,
    val minTemperature: Int = 0,
    val isDay: Boolean = true,

)