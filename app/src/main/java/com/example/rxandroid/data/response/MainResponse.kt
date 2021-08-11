package com.example.rxandroid.data.response

import com.example.rxandroid.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class MainResponse(
    @SerializedName("temp")
    val temp: Double = ConstantUtils.DOUBLE_DEFAULT,
    @SerializedName("feels_like")
    val feelsLike: Double = ConstantUtils.DOUBLE_DEFAULT,
    @SerializedName("temp_min")
    val tempMin: Double = ConstantUtils.DOUBLE_DEFAULT,
    @SerializedName("temp_max")
    val tempMax: Double = ConstantUtils.DOUBLE_DEFAULT,
    @SerializedName("pressure")
    val pressure: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("sea_level")
    val seaLevel: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("ground_level")
    val groundLevel: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("humidity")
    val humidity: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("temp_kf")
    val tempKf: Double = ConstantUtils.DOUBLE_DEFAULT
)
