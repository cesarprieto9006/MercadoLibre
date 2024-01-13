package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("plain_text")
    val text: String?
)