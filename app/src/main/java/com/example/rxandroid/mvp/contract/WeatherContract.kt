package com.example.rxandroid.mvp.contract

import com.example.rxandroid.adapter.WeatherAdapter
import com.example.rxandroid.domain.entity.ForecastApiEntity
import io.reactivex.rxjava3.core.Observable

interface WeatherContract {

    interface WeatherModelContract {
        fun getObservableWeatherForecast(): Observable<ForecastApiEntity>
    }

    interface WeatherPresenterContract {
        fun getWeatherForecast(onWeatherListener: WeatherAdapter.OnWeatherListener)
        fun onRecyclerItemClicked(position: Int)
    }

    interface WeatherViewContract {
        fun showWeatherForecast(forecastApiEntity: ForecastApiEntity, onWeatherListener: WeatherAdapter.OnWeatherListener)
        fun showExtendedInformation(position: Int)
        fun showProgressBar()
    }
}
