package com.example.rxandroid.data.response

import com.example.rxandroid.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class RainResponse(
    @SerializedName("3h")
    val threeH: Double = ConstantUtils.DOUBLE_DEFAULT
)
