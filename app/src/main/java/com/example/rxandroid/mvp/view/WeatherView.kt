package com.example.rxandroid.mvp.view

import android.app.Activity
import com.example.rxandroid.databinding.ActivityWeatherBinding
import com.example.rxandroid.mvp.contract.WeatherContract
import com.example.rxandroid.mvp.view.base.ActivityView

class WeatherView(activity: Activity, private val binding: ActivityWeatherBinding) : ActivityView(activity), WeatherContract.WeatherViewContract {
}
