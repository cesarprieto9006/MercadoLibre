package com.example.data.remote.datasource

import arrow.core.Either
import com.example.data.di.GeneralError
import com.example.data.dto.ProductData
import com.example.data.extension.tryCall
import com.example.data.model.ProductDataResponse
import com.example.data.remote.MercadoLibreApi
import javax.inject.Inject

const val EMPTY_STRING =""

class ProductServerDataSource @Inject constructor(
    private val mercadoLibreApi: MercadoLibreApi
) : ProductRemoteDataSource {

    override suspend fun getSearchProduct(
        name: String
    ): Either<GeneralError, List<ProductData>> = tryCall {
        mercadoLibreApi.getProductsByName(name).results.toDomainModel()
    }

    private fun List<ProductDataResponse>.toDomainModel(): List<ProductData> =
        map { it.toDomainModel() }

    private fun ProductDataResponse.toDomainModel(): ProductData = ProductData(
        id = id ?: EMPTY_STRING,
        pictureUrl = thumbnail ?: EMPTY_STRING,
        price = price ?: 0,
        title = title ?: EMPTY_STRING,
        condition = condition ?: EMPTY_STRING
    )

}