package com.example.rxandroid.mvp.contract

import com.example.rxandroid.domain.entity.ForecastApiEntity
import io.reactivex.rxjava3.core.Observable

interface WeatherContract {

    interface WeatherModelContract {
        fun getObservableWeatherForecast(): Observable<ForecastApiEntity>
    }

    interface WeatherPresenterContract {
        fun getWeatherForecast()
    }

    interface WeatherViewContract {
        fun showWeatherForecast(forecastApiEntity: ForecastApiEntity)
    }
}
