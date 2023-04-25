package com.example.weatherforecast.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherforecast.App
import com.example.weatherforecast.MainViewModelFactory
import com.example.weatherforecast.WeatherAdapter
import com.example.weatherforecast.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val weatherAdapter = WeatherAdapter()
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recycleViewInit()

        viewModelFactory = MainViewModelFactory(App.repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.weatherList.observe(this) {
            weatherAdapter.submitList(it)
        }
    }

    private fun recycleViewInit() {
        binding.rvWeather.adapter = weatherAdapter
        binding.rvWeather.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}