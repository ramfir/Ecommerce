package com.firdavs.impl.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.firdavs.api.CartEntry
import com.firdavs.api.LocalDataProvider
import com.firdavs.api.MainEntry
import com.firdavs.api.ProductDetailsEntry
import com.firdavs.common.Destinations
import com.firdavs.common.di.LocalCommonProvider
import com.firdavs.common.di.injectedViewModel
import com.firdavs.common.find
import com.firdavs.impl.di.DaggerMainComponent
import com.firdavs.impl.presentation.ui.MainScreen
import javax.inject.Inject

class MainEntryImpl @Inject constructor(): MainEntry() {

    @Composable
    override fun Composable(
        navController: NavController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
    ) {
        val dataProvider = LocalDataProvider.current
        val commonProvider = LocalCommonProvider.current
        val viewModel = injectedViewModel {
            DaggerMainComponent.builder()
                .dataProvider(dataProvider)
                .commonProvider(commonProvider)
                .build()
                .viewModel
        }
        MainScreen(
            viewModel,
            onProductClick = { product ->
                val destination = destinations
                    .find<ProductDetailsEntry>()
                    .destination(product.id)
                navController.navigate(destination)
            },
            onCartClick = {
                val destination = destinations
                    .find<CartEntry>()
                    .destination()
                navController.navigate(destination)
            }
        )
    }
}