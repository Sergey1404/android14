package com.example.weatherforecast.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.App
import com.example.weatherforecast.Constants
import com.example.weatherforecast.data.toDomain
import com.example.weatherforecast.data.toEntity
import com.example.weatherforecast.domain.Weather
import com.example.weatherforecast.domain.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel(private val repository: WeatherRepository) : ViewModel() {
    private val _weatherList = MutableLiveData<List<Weather>>()
    val weatherList get() = _weatherList

    init {
        loadWeather()
    }

    private fun loadWeather() {
        CoroutineScope(Dispatchers.IO).launch {
            _weatherList.postValue(repository.loadWeather())
        }
    }
}