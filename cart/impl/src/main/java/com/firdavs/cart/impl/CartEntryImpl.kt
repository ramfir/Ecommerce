package com.firdavs.cart.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.firdavs.api.CartEntry
import com.firdavs.api.LocalDataProvider
import com.firdavs.cart.impl.di.DaggerCartComponent
import com.firdavs.common.Destinations
import com.firdavs.common.di.LocalCommonProvider
import com.firdavs.common.di.injectedViewModel
import com.firdavs.common.find
import com.firdavs.cart.impl.ui.CartScreen
import javax.inject.Inject

class CartEntryImpl @Inject constructor(): CartEntry() {

    @Composable
    override fun Composable(
        navController: NavController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
    ) {
        val dataProvider = LocalDataProvider.current
        val commonProvider = LocalCommonProvider.current
        val viewModel = injectedViewModel {
            DaggerCartComponent.builder()
                .dataProvider(dataProvider)
                .commonProvider(commonProvider)
                .build()
                .viewModel
        }

        CartScreen(viewModel)
    }
}