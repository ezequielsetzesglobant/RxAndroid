package com.example.rxandroid.data.response

import com.example.rxandroid.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class CoordResponse(
    @SerializedName("lat")
    val lat: Double = ConstantUtils.DOUBLE_DEFAULT,
    @SerializedName("lon")
    val lon: Double = ConstantUtils.DOUBLE_DEFAULT
)
