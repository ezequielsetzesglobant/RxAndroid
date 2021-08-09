package com.example.rxandroid.domain.entity

data class DayEntity(
    val dt: Int,
    val main: MainEntity,
    val weather: List<WeatherEntity>,
    val clouds: CloudsEntity,
    val wind: WindEntity,
    val visibility: Int,
    val pop: Double,
    val rain: RainEntity,
    val sys: SysEntity,
    val dtTxt: String
)
