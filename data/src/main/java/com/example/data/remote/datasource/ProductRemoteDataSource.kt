package com.example.data.remote.datasource
import arrow.core.Either
import com.example.data.di.GeneralError
import com.example.data.dto.ProductData
import com.example.data.dto.ProductDetails

interface ProductRemoteDataSource {
    suspend fun getSearchProduct(name: String): Either<GeneralError, List<ProductData>>
    suspend fun getProductDetails(productId: String): Either<GeneralError, ProductDetails>

}