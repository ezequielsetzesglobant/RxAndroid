package com.example.rxandroid.data.api

import com.example.rxandroid.data.response.ForecastApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast?")
    fun getResponseWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String
    ): Call<ForecastApiResponse>
}

