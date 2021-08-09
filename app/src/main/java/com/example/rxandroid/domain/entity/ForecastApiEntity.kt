package com.example.rxandroid.domain.entity

data class ForecastApiEntity(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<DayEntity>,
    val city: CityEntity
)
