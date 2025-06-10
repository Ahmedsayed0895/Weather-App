package com.example.weatherapp.domain.usecase

import com.example.weatherapp.domain.model.WeatherResponse
import com.example.weatherapp.domain.repository.WeatherRepository

class GetWeatherUseCase(
    val weatherRepository: WeatherRepository
) {
    suspend  fun getWeatherData(): WeatherResponse {
        return weatherRepository.getWeatherData()
    }

}