package com.example.mercadolibre.ui.product.fragment.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.data.dto.ProductData
import com.example.domain.SearchProductUseCase
import com.example.mercadolibre.ui.product.fragment.TypeImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainViewModel @Inject constructor(
    @Named("IO") private val ioDispatcher: CoroutineDispatcher,
    private val searchProductUseCase: SearchProductUseCase,
) : ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _product = MutableLiveData<List<ProductData>?>()
    val product: LiveData<List<ProductData>?> get() = _product

    private val _searchProductVisibility = MutableLiveData(true)
    val searchProductVisibility: LiveData<Boolean?> get() = _searchProductVisibility

    private val _selectImage = MutableLiveData(TypeImage.SEARCH)
    val selectImage: LiveData<TypeImage?> get() = _selectImage

    private val _showList = MutableLiveData(false)
    val showList: LiveData<Boolean> get() = _showList

    fun searchProduct(text: String) {
        _isLoading.postValue(true)
        _searchProductVisibility.postValue(false)
        _showList.postValue(false)
        viewModelScope.launch(ioDispatcher) {
            when (val result = searchProductUseCase.invoke(text)) {
                is Either.Left -> {
                    _searchProductVisibility.postValue(true)
                    _selectImage.postValue(TypeImage.ERROR)
                }

                is Either.Right -> {
                    val product = result.value
                    validateProduct(product)
                }
            }
            _isLoading.postValue(false)
        }
    }

    private fun validateProduct(product:List<ProductData>){
        if (product.isNotEmpty()) {
            _showList.postValue(true)
            _product.postValue(product)
        } else {
            _searchProductVisibility.postValue(true)
            _selectImage.postValue(TypeImage.NOT_FOUND)
        }
    }

}

