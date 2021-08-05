package com.example.rxandroid.mvp.presenter

import com.example.rxandroid.mvp.contract.WeatherContract

class WeatherPresenter(private val model: WeatherContract.WeatherModelContract, private val view: WeatherContract.WeatherViewContract) :
    WeatherContract.WeatherPresenterContract {
}
