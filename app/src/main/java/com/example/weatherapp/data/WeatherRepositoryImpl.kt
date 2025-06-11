package com.example.weatherapp.data

import com.example.weatherapp.domain.model.WeatherResponse
import com.example.weatherapp.domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class WeatherRepositoryImpl:WeatherRepository {
    val client = HttpClient(CIO)
    val url = "https://api.open-meteo.com/v1/forecast?latitude=30.0626&longitude=31.2497&daily=temperature_2m_max,temperature_2m_min&hourly=temperature_2m&current=temperature_2m,relative_humidity_2m,apparent_temperature,is_day,precipitation,rain,weather_code,pressure_msl,surface_pressure,wind_speed_10m&timezone=Africa%2FCairo"
    override suspend fun getWeatherData(): WeatherResponse {
        return try {
            val response = client.get(urlString = url)
            Json.decodeFromString<WeatherResponse>(response.bodyAsText())
        }catch (e:Exception){
         throw Exception(e)
        }


    }
}

