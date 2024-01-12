package com.example.data.remote

import com.example.data.model.ProductListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MercadoLibreApi {
    @GET("sites/MCO/search")
    suspend fun getProductsByName(
        @Query("q") productName: String
    ): ProductListResponse

}