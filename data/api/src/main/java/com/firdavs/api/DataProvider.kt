package com.firdavs.api

import androidx.compose.runtime.compositionLocalOf
import com.firdavs.common.domain.ProductsRepository

interface DataProvider {

    val productsRepository: ProductsRepository
}

val LocalDataProvider = compositionLocalOf<DataProvider> { error("No data provider found!") }