package com.firdavs.common.domain

import com.firdavs.common.domain.model.Products
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProducts(): Flow<Products>
}