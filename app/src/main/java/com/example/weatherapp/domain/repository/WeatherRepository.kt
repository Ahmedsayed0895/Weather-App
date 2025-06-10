package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.model.WeatherResponse

interface WeatherRepository {
    suspend fun getWeatherData(): WeatherResponse

}