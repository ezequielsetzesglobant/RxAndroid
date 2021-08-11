package com.example.rxandroid.data.mapper

import com.example.rxandroid.data.response.CityResponse
import com.example.rxandroid.data.response.CloudsResponse
import com.example.rxandroid.data.response.CoordResponse
import com.example.rxandroid.data.response.DayResponse
import com.example.rxandroid.data.response.ForecastApiResponse
import com.example.rxandroid.data.response.MainResponse
import com.example.rxandroid.data.response.RainResponse
import com.example.rxandroid.data.response.SysResponse
import com.example.rxandroid.data.response.WeatherResponse
import com.example.rxandroid.data.response.WindResponse
import com.example.rxandroid.domain.entity.CityEntity
import com.example.rxandroid.domain.entity.CloudsEntity
import com.example.rxandroid.domain.entity.CoordEntity
import com.example.rxandroid.domain.entity.DayEntity
import com.example.rxandroid.domain.entity.ForecastApiEntity
import com.example.rxandroid.domain.entity.MainEntity
import com.example.rxandroid.domain.entity.RainEntity
import com.example.rxandroid.domain.entity.SysEntity
import com.example.rxandroid.domain.entity.WeatherEntity
import com.example.rxandroid.domain.entity.WindEntity

fun ForecastApiResponse.transform() = ForecastApiEntity(
    cod = this.cod,
    message = this.message,
    cnt = this.cnt,
    list = this.list.map { it.transform() },
    city = this.city.transform()
)

private fun DayResponse.transform() = DayEntity(
    dt = this.date,
    main = this.main.transform(),
    weather = this.weather.map { it.transform() },
    clouds = this.clouds.transform(),
    wind = this.wind.transform(),
    visibility = this.visibility,
    pop = this.pop,
    rain = this.rain.transform(),
    sys = this.sys.transform(),
    dtTxt = this.dtTxt
)

private fun MainResponse.transform() = MainEntity(
    temp = this.temp,
    feelsLike = this.feelsLike,
    temMin = this.tempMin,
    tempMax = this.tempMax,
    pressure = this.pressure,
    seaLevel = this.seaLevel,
    groundLevel = this.groundLevel,
    humidity = this.humidity,
    tempKf = this.tempKf
)

private fun WeatherResponse.transform() = WeatherEntity(
    id = this.id,
    main = this.main,
    description = this.description,
    icon = this.icon
)

private fun CloudsResponse.transform() = CloudsEntity(all = this.all)

private fun WindResponse.transform() = WindEntity(speed = this.speed, deg = this.deg, gust = this.gust)

private fun RainResponse.transform() = RainEntity(threeH = this.threeH)

private fun SysResponse.transform() = SysEntity(pod = this.pod)

private fun CityResponse.transform() = CityEntity(
    id = this.id,
    name = this.name,
    coord = this.coord.transform(),
    country = this.country,
    population = this.population,
    timezone = this.timezone,
    sunrise = this.sunrise,
    sunset = this.sunset
)

private fun CoordResponse.transform() = CoordEntity(lat = this.lat, lon = this.lon)
