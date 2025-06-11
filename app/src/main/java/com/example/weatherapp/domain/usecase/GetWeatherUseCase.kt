package com.example.weatherapp.domain.usecase

import com.example.weatherapp.domain.model.WeatherResponse
import com.example.weatherapp.domain.repository.WeatherRepository

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(): WeatherResponse {
        return weatherRepository.getWeatherData()
    }


}