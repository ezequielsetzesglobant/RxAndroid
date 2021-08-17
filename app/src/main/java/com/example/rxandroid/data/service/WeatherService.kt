package com.example.rxandroid.data.service

import com.example.rxandroid.BuildConfig
import com.example.rxandroid.data.api.WeatherApi
import com.example.rxandroid.data.mapper.transform
import com.example.rxandroid.domain.entity.ForecastApiEntity
import io.reactivex.rxjava3.core.Observable

class WeatherService: Service {

    private val weatherRequestGenerator = WeatherRequestGenerator()

    override fun getObservableForecastApi(): Observable<ForecastApiEntity> = Observable.create { subscriber ->
        val response =
            weatherRequestGenerator.generateRequest(WeatherApi::class.java).getResponseWeather(CITY_NAME, BuildConfig.API_KEY, UNITS)
                .execute()
        if (response.isSuccessful) {
            subscriber.onNext(response.body()?.transform())
        } else {
            subscriber.onError(Throwable(response.message()))
        }
    }

    companion object {
        private const val CITY_NAME: String = "Tandil"
        private const val UNITS: String = "metric"
    }
}
