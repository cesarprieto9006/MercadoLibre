package com.example.data.remote.datasource

import arrow.core.Either
import com.example.data.di.GeneralError
import com.example.data.dto.ProductData
import com.example.data.dto.ProductDetails
import com.example.data.extension.tryCall
import com.example.data.model.ProductDataResponse
import com.example.data.remote.MercadoLibreApi
import com.example.data.model.Description
import com.example.data.model.ProductDetailsResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

const val EMPTY_STRING = ""

class ProductServerDataSource @Inject constructor(
    private val mercadoLibreApi: MercadoLibreApi
) : ProductRemoteDataSource {

    override suspend fun getSearchProduct(
        name: String
    ): Either<GeneralError, List<ProductData>> = tryCall {
        mercadoLibreApi.getProductsByName(name).results.toDomainModel()
    }

    override suspend fun getProductDetails(productId: String): Either<GeneralError,
            ProductDetails> = tryCall {
        lateinit var details: ProductDetailsResponse
        lateinit var description: Description

        coroutineScope {
            val detailsResponse = async { getDetailsById(productId) }
            val descriptionResponse = async { getDescriptionById(productId) }

            details = detailsResponse.await()
            description = descriptionResponse.await()
        }

        details.toDomainModel(description)

    }


    private suspend fun getDetailsById(productId: String): ProductDetailsResponse {
        return mercadoLibreApi.getDetailsById(productId)
    }

    private suspend fun getDescriptionById(productId: String): Description {
        return mercadoLibreApi.getDescriptionById(productId)
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

    private fun ProductDetailsResponse.toDomainModel(
        description: Description,
    ): ProductDetails = ProductDetails(
        acceptsMercadopago = acceptsMercadopago ?: false,
        availableQuantity = availableQuantity ?: 0,
        condition = condition ?: "",
        description = description.text ?: "",
        freeShipping = shipping?.freeShipping ?: false,
        id = id ?: "",
        location = (sellerAddress?.city?.name + ", " + sellerAddress?.state?.name),
        pictureUrl = secureThumbnail ?: "",
        picturesUrl = pictures?.mapNotNull { it?.secureUrl } ?: emptyList(),
        price = price ?: 0,
        title = title ?: ""
    )

}