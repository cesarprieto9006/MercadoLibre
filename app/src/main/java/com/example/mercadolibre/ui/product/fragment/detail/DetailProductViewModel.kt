package com.example.mercadolibre.ui.product.fragment.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.data.dto.ProductDetails
import com.example.domain.GetProductDetailsUseCase
import com.example.mercadolibre.ui.product.fragment.TypeImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class DetailProductViewModel @Inject constructor(
    @Named("IO") private val ioDispatcher: CoroutineDispatcher,
    private val getProductDetailsUseCase: GetProductDetailsUseCase

) : ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _product = MutableLiveData<ProductDetails?>()
    val product: LiveData<ProductDetails?> get() = _product

    private val _selectImage = MutableLiveData(TypeImage.SEARCH)
    val selectImage: LiveData<TypeImage?> get() = _selectImage

    private val _searchProductVisibility = MutableLiveData(false)
    val searchProductVisibility: LiveData<Boolean?> get() = _searchProductVisibility

    fun getProductDetails(productId: String) {
        _isLoading.postValue(true)
        _searchProductVisibility.postValue(false)
        viewModelScope.launch(ioDispatcher) {
            when (val product = getProductDetailsUseCase(productId)) {
                is Either.Left -> {
                    _searchProductVisibility.postValue(true)
                    _selectImage.postValue(TypeImage.ERROR)
                }

                is Either.Right -> {
                    _product.postValue(product.value)
                }
            }
            _isLoading.postValue(false)
        }
    }

}