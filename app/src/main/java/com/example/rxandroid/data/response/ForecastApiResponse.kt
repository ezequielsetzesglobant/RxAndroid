package com.example.rxandroid.data.response

import com.example.rxandroid.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class ForecastApiResponse(
    @SerializedName("cod")
    val cod: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("message")
    val message: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("cnt")
    val cnt: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("list")
    val list: List<DayResponse> = emptyList(),
    @SerializedName("city")
    val city: CityResponse = CityResponse()
)
