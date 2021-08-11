package com.example.rxandroid.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxandroid.data.service.WeatherService
import com.example.rxandroid.databinding.ActivityWeatherBinding
import com.example.rxandroid.mvp.contract.WeatherContract
import com.example.rxandroid.mvp.model.WeatherModel
import com.example.rxandroid.mvp.presenter.WeatherPresenter
import com.example.rxandroid.mvp.view.WeatherView

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding
    private lateinit var presenter: WeatherContract.WeatherPresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = WeatherPresenter(WeatherModel(WeatherService()), WeatherView(this, binding))

        binding.buttonWeatherActivityIdForecast.setOnClickListener { presenter.getWeatherForecast() }
    }
}
