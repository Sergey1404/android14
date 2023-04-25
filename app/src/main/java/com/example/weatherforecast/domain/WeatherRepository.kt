package com.example.weatherforecast.domain

interface WeatherRepository {

    suspend fun loadWeather(): List<Weather>
}