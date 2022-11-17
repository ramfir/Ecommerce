package com.firdavs.api

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.firdavs.common.ComposableFeatureEntry

abstract class ProductDetailsEntry : ComposableFeatureEntry {

    final override val featureRoute = "product-details/{$ARG_PRODUCT_ID}"

    final override val arguments = listOf(
        navArgument(ARG_PRODUCT_ID) {
            type = NavType.IntType
        }
    )

    fun destination(productId: Int): String =
        "product-details/$productId"

    protected companion object {
        const val ARG_PRODUCT_ID = "productId"
    }
}