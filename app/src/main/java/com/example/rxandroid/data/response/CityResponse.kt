package com.example.rxandroid.data.response

import com.example.rxandroid.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("id")
    val id: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("name")
    val name: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("coord")
    val coord: CoordResponse = CoordResponse(),
    @SerializedName("country")
    val country: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("population")
    val population: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("timezone")
    val timezone: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("sunrise")
    val sunrise: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("sunset")
    val sunset: Int = ConstantUtils.INT_DEFAULT
)
