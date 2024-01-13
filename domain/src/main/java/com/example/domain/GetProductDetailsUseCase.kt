package com.example.domain

import arrow.core.Either
import com.example.data.di.GeneralError
import com.example.data.dto.ProductDetails
import com.example.data.repository.ProductRepository
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val productsRepository: ProductRepository
) {
    suspend operator fun invoke(productId: String): Either<GeneralError, ProductDetails> =
        productsRepository.getProductDetails(productId)
}