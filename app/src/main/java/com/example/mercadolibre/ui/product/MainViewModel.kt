package com.example.mercadolibre.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.data.dto.ProductData
import com.example.domain.SearchProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainViewModel @Inject constructor(
    @Named("IO") private val ioDispatcher: CoroutineDispatcher,
    private val searchProductUseCase: SearchProductUseCase

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
                    if(product.isNotEmpty()) {
                        _showList.postValue(true)
                        _product.postValue(result.value)
                    }
                    else {
                        _searchProductVisibility.postValue(true)
                        _selectImage.postValue(TypeImage.NOT_FOUND)
                    }

                }
            }
            _isLoading.postValue(false)
        }
    }

}

enum class TypeImage {
    SEARCH,               //Types.FOO.ordinal == 0 also position == 0
    ERROR,               //Types.BAR.ordinal == 1 also position == 1
    NOT_FOUND            //Types.FOO_BAR.ordinal == 2 also position == 2
}