package com.example.rxandroid.data.response

import com.example.rxandroid.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("id")
    val id: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("main")
    val main: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("description")
    val description: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("icon")
    val icon: String = ConstantUtils.STRING_DEFAULT
)
