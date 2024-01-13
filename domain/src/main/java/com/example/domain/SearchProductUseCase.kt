package com.example.domain

import arrow.core.Either
import com.example.data.di.GeneralError
import com.example.data.dto.ProductData
import com.example.data.repository.ProductRepository
import javax.inject.Inject

class SearchProductUseCase @Inject constructor(
    private val productsRepository: ProductRepository
) {
    suspend operator fun invoke(name: String): Either<GeneralError, List<ProductData>> =
        productsRepository.getSearchProduct(name)
}