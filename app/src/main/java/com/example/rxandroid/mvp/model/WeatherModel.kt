package com.example.rxandroid.mvp.model

import com.example.rxandroid.data.service.Service
import com.example.rxandroid.domain.entity.ForecastApiEntity
import com.example.rxandroid.mvp.contract.WeatherContract
import io.reactivex.rxjava3.core.Observable

class WeatherModel(private val weatherService: Service) : WeatherContract.WeatherModelContract {

    override fun getObservableWeatherForecast(): Observable<ForecastApiEntity> = weatherService.getObservableForecastApi()
}
