package com.example.rxandroid.mvp.presenter

import com.example.rxandroid.mvp.contract.WeatherContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class WeatherPresenter(private val model: WeatherContract.WeatherModelContract, private val view: WeatherContract.WeatherViewContract) :
    WeatherContract.WeatherPresenterContract {

    override fun getWeatherForecast() {
        model.getObservableWeatherForecast()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
            }
    }
}
