package com.firdavs.product_details.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.firdavs.api.LocalDataProvider
import com.firdavs.api.ProductDetailsEntry
import com.firdavs.common.Destinations
import com.firdavs.common.di.LocalCommonProvider
import com.firdavs.common.di.injectedViewModel
import com.firdavs.product_details.impl.di.DaggerProductDetailsComponent
import com.firdavs.product_details.impl.ui.ProductDetailsScreen
import javax.inject.Inject

class ProductDetailsEntryImpl @Inject constructor() : ProductDetailsEntry() {

    @Composable
    override fun Composable(
        navController: NavController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val dataProvider = LocalDataProvider.current
        val commonProvider = LocalCommonProvider.current
        val viewModel = injectedViewModel {
            DaggerProductDetailsComponent.builder()
                .dataProvider(dataProvider)
                .commonProvider(commonProvider)
                .build()
                .viewModel
        }

        val productId = backStackEntry.arguments?.getInt(ARG_PRODUCT_ID)!!


        ProductDetailsScreen(
            productId,
            viewModel,
            navController::popBackStack
        )
    }
}