package com.firdavs.product_details.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firdavs.common.domain.model.ProductDetails
import com.firdavs.product_details.impl.domain.GetProductDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(
    getProductDetails: GetProductDetails
): ViewModel() {

    init {
        getProductDetails()
            .onEach {
                _productDetails.value = it
            }
            .launchIn(viewModelScope)
    }

    private val _productDetails = MutableStateFlow<ProductDetails?>(null)
    val productDetails: StateFlow<ProductDetails?> = _productDetails
}