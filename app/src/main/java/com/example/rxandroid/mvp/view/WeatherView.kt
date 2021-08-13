package com.example.rxandroid.mvp.view

import android.app.Activity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxandroid.adapter.WeatherAdapter
import com.example.rxandroid.databinding.ActivityWeatherBinding
import com.example.rxandroid.domain.entity.ForecastApiEntity
import com.example.rxandroid.mvp.contract.WeatherContract
import com.example.rxandroid.mvp.view.base.ActivityView

class WeatherView(activity: Activity, private val binding: ActivityWeatherBinding) : ActivityView(activity),
    WeatherContract.WeatherViewContract {

    override fun showWeatherForecast(forecastApiEntity: ForecastApiEntity) {
        binding.recyclerViewDailiesRecyclerActivityList.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewDailiesRecyclerActivityList.adapter = WeatherAdapter(forecastApiEntity.list)
    }
}
