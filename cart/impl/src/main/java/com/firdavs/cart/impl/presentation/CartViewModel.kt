package com.firdavs.cart.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firdavs.cart.impl.domain.GetCartProducts
import com.firdavs.common.domain.model.CartProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CartViewModel @Inject constructor(
    getCartProducts: GetCartProducts
) : ViewModel() {

    init {
        getCartProducts()
            .onEach {
                _cartProducts.value = it
            }
            .launchIn(viewModelScope)
    }

    private val _cartProducts = MutableStateFlow<CartProducts?>(null)
    val cartProducts: StateFlow<CartProducts?> = _cartProducts
}