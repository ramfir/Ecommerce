package com.firdavs.common.domain

import com.firdavs.common.domain.model.CartProducts
import com.firdavs.common.domain.model.ProductDetails
import com.firdavs.common.domain.model.Products
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProducts(): Flow<Products>

    fun getProductDetails(): Flow<ProductDetails>

    fun getCartProducts(): Flow<CartProducts>
}