package com.example.weatherapp.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.model.DailyWeather
import com.example.weatherapp.domain.model.HourlyWeather
import com.example.weatherapp.ui.viewModel.state.WeatherState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WeatherViewModel: ViewModel() {
    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    fun onCurrentTemperatureChange(temperature: Int){
        _state.update { it.copy(currentTemperature = temperature) }
    }
    fun onWeatherDescriptionChange(description: String){
        _state.update { it.copy(weatherDescription = description) }
    }
    fun onMaxTemperatureChange(maxTemperature: Int){
        _state.update { it.copy(maxTemperature = maxTemperature) }
    }
    fun onMinTemperatureChange(minTemperature: Int){
        _state.update { it.copy(minTemperature = minTemperature) }
    }
    fun onWindSpeedChange(windSpeed: Int){
        _state.update { it.copy(windSpeed = windSpeed) }
    }
    fun onRainChange(rain: Int){
        _state.update { it.copy(rain = rain) }
    }
    fun onHumidityChange(humidity: Int){
        _state.update { it.copy(humidity = humidity) }
    }
    fun onUvIndexChange(uvIndex: Int){
        _state.update { it.copy(uvIndex = uvIndex) }
    }
    fun onPressureChange(pressure: Int){
        _state.update { it.copy(pressure = pressure) }
    }

    fun onHourlyWeatherChange(hourlyWeather: List<HourlyWeather>){
        _state.update { it.copy(hourlyWeather = hourlyWeather) }
    }

    fun onDailyWeatherChange(dailyWeather: List<DailyWeather>){
        _state.update { it.copy(dailyWeather = dailyWeather) }
    }













    }

