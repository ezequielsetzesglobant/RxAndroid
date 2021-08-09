package com.example.rxandroid.domain.entity

data class CityEntity (
    val id: Int,
    val name: String,
    val coord: CoordEntity,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Int,
    val sunset: Int
)
