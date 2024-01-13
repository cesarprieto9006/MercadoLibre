package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("secure_url") val secureUrl: String?,
)