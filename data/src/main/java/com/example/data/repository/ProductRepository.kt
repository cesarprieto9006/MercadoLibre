package com.example.data.repository

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.example.data.di.GeneralError
import com.example.data.dto.ProductData
import com.example.data.remote.datasource.ProductRemoteDataSource
import javax.inject.Inject

class ProductRepository @Inject constructor(private val remoteDataSource: ProductRemoteDataSource) {
    suspend fun getSearchProduct(name: String): Either<GeneralError, List<ProductData>> {
        return remoteDataSource.getSearchProduct(name)
            .fold(
                { error -> error.left() },
                { products -> products.right() }
            )
    }
}