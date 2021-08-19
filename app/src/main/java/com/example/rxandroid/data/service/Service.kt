package com.example.rxandroid.data.service

import com.example.rxandroid.domain.entity.ForecastApiEntity
import io.reactivex.rxjava3.core.Observable

interface Service {

    fun getObservableForecastApi(): Observable<ForecastApiEntity>
}
