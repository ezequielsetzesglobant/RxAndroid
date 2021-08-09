package com.example.rxandroid.data.response

import com.example.rxandroid.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class DayResponse(
    @SerializedName("dt")
    val date: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("main")
    val main: MainResponse = MainResponse(),
    @SerializedName("weather")
    val weather: List<WeatherResponse> = emptyList(),
    @SerializedName("clouds")
    val clouds: CloudsResponse = CloudsResponse(),
    @SerializedName("wind")
    val wind: WindResponse = WindResponse(),
    @SerializedName("visibility")
    val visibility: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("pop")
    val pop: Double = ConstantUtils.DOUBLE_DEFAULT,
    @SerializedName("rain")
    val rain: RainResponse = RainResponse(),
    @SerializedName("sys")
    val sys: SysResponse = SysResponse(),
    @SerializedName("dt_txt")
    val dtTxt: String = ConstantUtils.STRING_DEFAULT
)
