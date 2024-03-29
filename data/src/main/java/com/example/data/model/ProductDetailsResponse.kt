package com.example.data.model

import com.google.gson.annotations.SerializedName

data class ProductDetailsResponse(
    @SerializedName("accepts_mercadopago")
    val acceptsMercadopago: Boolean?,
    @SerializedName("available_quantity")
    val availableQuantity: Int?,
    val condition: String?,
    val shipping: Shipping?,
    val id: String?,
    val pictures: List<Picture?>?,
    val price: Int?,
    @SerializedName("secure_thumbnail")
    val secureThumbnail: String?,
    @SerializedName("seller_address")
    val sellerAddress: SellerAddress?,
    val title: String?
)