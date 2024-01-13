package com.example.data.model

import com.google.gson.annotations.SerializedName

data class ProductDataResponse(
    @SerializedName("accepts_mercadopago") val acceptsMercadopago: Boolean?,
    @SerializedName("id") val id: String?,
    @SerializedName("seller_address") val sellerAddress: SellerAddress?,
    @SerializedName("price") val price: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("condition") val condition: String?,
)