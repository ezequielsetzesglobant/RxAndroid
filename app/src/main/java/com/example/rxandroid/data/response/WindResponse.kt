package com.example.rxandroid.data.response

import com.example.rxandroid.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class WindResponse(
    @SerializedName("speed")
    val speed: Double = ConstantUtils.DOUBLE_DEFAULT,
    @SerializedName("deg")
    val deg: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("gust")
    val gust: Double = ConstantUtils.DOUBLE_DEFAULT
)
