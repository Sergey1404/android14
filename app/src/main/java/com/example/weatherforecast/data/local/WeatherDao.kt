package com.example.weatherforecast.data.local

import androidx.room.*

@Dao
interface WeatherDao {
    @Insert
    suspend fun saveWeather(vararg weather: WeatherEntity)

    @Query(value = "Select * from WeatherEntity")
    suspend fun getAllWeather() : List<WeatherEntity>

    //Селект каунт калл
    //Запросы sql statement ignore
    @Query("SELECT COUNT(*) FROM WeatherEntity WHERE dtTxt = :date")
    suspend fun getWeatherCountByDate(date: String): Int
}