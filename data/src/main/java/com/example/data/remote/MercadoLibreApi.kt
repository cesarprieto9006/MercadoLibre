package com.example.data.remote

import com.example.data.model.ProductListResponse
import com.example.data.model.Description
import com.example.data.model.ProductDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MercadoLibreApi {
    @GET("sites/MCO/search")
    suspend fun getProductsByName(
        @Query("q") productName: String
    ): ProductListResponse

    @GET("items/{productId}")
    suspend fun getDetailsById(
        @Path("productId") productId: String
    ): ProductDetailsResponse

    @GET("items/{productId}/description")
    suspend fun getDescriptionById(
        @Path("productId") productId: String
    ): Description
}