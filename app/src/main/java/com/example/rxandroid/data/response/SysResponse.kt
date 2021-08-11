package com.example.rxandroid.data.response

import com.example.rxandroid.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class SysResponse(
    @SerializedName("pod")
    val pod: String = ConstantUtils.STRING_DEFAULT
)
