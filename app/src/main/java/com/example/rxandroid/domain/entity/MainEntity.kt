package com.example.rxandroid.domain.entity

data class MainEntity(
    val temp: Double,
    val feelsLike: Double,
    val temMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val seaLevel: Int,
    val groundLevel: Int,
    val humidity: Int,
    val tempKf: Double
)
