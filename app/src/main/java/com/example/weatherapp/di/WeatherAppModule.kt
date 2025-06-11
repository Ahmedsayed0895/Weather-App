package com.example.weatherapp.di

import com.example.weatherapp.data.WeatherRepositoryImpl
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.usecase.GetWeatherUseCase
import com.example.weatherapp.ui.viewModel.WeatherViewModel
import org.koin.dsl.module

    val appModule = module {
        single { WeatherViewModel(get()) }
        single <WeatherRepository>{ WeatherRepositoryImpl() }
        single { GetWeatherUseCase(get()) }
    }


