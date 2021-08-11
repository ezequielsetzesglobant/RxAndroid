package com.example.rxandroid.data.response

import com.example.rxandroid.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class CloudsResponse(
    @SerializedName("all")
    val all: Int = ConstantUtils.INT_DEFAULT
)
