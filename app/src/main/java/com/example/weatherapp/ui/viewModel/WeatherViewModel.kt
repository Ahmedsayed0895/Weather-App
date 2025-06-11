package com.example.weatherapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.usecase.GetWeatherUseCase
import com.example.weatherapp.ui.viewModel.state.WeatherState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
  val  getWeatherUseCase: GetWeatherUseCase
): ViewModel() {


    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    init {
        getWeather()
    }

    private fun getWeather(){

        viewModelScope.launch {
            val getWeather= getWeatherUseCase()

            _state.update { it.copy(

                currentTemperature =  getWeather.currentWeather.temperature2m.toInt(),
                humidity = getWeather.currentWeather.relativeHumidity2m,
                apparentTemperature = getWeather.currentWeather.apparentTemperature.toInt(),
                weatherDescription = weatherDescription(getWeather.currentWeather.weatherCode),
                windSpeed = getWeather.currentWeather.windSpeed10m.toInt(),
                rain = getWeather.currentWeather.rain.toInt(),
                pressure = getWeatherUseCase().currentWeather.pressureMsl.toInt(),
                hourlyWeather = getWeather.hourlyWeather.temperature2m.take(24),
                hourlyTime = getWeather.hourlyWeather.time,
                dailyMaxDegree = getWeather.dailyWeather.temperature2mMax.map { it.toInt() },
                dailyMinDegree = getWeather.dailyWeather.temperature2mMin.map { it.toInt() },
                dailyTime = getWeather.dailyWeather.time,
                maxTemperature = getWeather.hourlyWeather.temperature2m.max().toInt(),
                minTemperature = getWeather.hourlyWeather.temperature2m.min().toInt(),
                isDay = getWeather.currentWeather.isDay == 1



            ) }
        }
    }


    private fun weatherDescription(weatherCode:Int):String{
        when(weatherCode){
            0 -> return "Clear sky"
            1-> return "Mainly clear"
            2-> return "Partly cloudy"
            3-> return "Overcast"
            45-> return "Fog"
            48-> return "Depositing rime fog"
            51-> return "Light drizzle"
            53-> return "Moderate drizzle"
            55-> return "Dense intensity drizzle"
            56-> return "Light freezing drizzle"
            57-> return "Dense freezing drizzle"
            61-> return "Slight rain"
            63-> return "Moderate rain"
            65-> return "Heavy intensity rain"
            66-> return "Light freezing rain"
            67-> return "Heavy freezing rain"
            71-> return "Slight snow fall"
            73-> return "Moderate snow fall"
            75-> return "Heavy snow fall"
            77-> return "Snow grains"
            80-> return "Slight rain showers"
            81-> return "Moderate rain showers"
            82-> return "Violent rain showers"
            85-> return "Slight snow showers"
            86-> return "Heavy snow showers"
            95-> return "Thunderstorm"
            96-> return "Slight or moderate thunderstorm"
            99-> return "Heavy thunderstorm"
            else -> return "Unknown"
        }
    }













    }

