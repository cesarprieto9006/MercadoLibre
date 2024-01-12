package com.example.data.remote.datasource
import arrow.core.Either
import com.example.data.di.GeneralError
import com.example.data.dto.ProductData

interface ProductRemoteDataSource {
    suspend fun getSearchProduct(name: String): Either<GeneralError, List<ProductData>>
}