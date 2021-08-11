package com.example.rxandroid.data.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRequestGenerator {

    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()

    fun <S> generateRequest(classAPI: Class<S>): S =
        Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(classAPI)

    companion object {
        private const val URL_BASE = "https://api.openweathermap.org/data/2.5/"
    }
}
