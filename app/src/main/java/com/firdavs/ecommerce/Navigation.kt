package com.firdavs.ecommerce

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.firdavs.api.CartEntry
import com.firdavs.api.MainEntry
import com.firdavs.api.ProductDetailsEntry
import com.firdavs.common.find
import com.firdavs.ecommerce.di.LocalAppProvider

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalAppProvider.current.destinations

    val mainScreen = destinations.find<MainEntry>()
    val productDetailsScreen = destinations.find<ProductDetailsEntry>()
    val cartScreen = destinations.find<CartEntry>()

    Box(Modifier.fillMaxSize()) {
        NavHost(navController = navController, startDestination = mainScreen.destination()) {
            with(mainScreen) {
                composable(navController, destinations)
            }
            with(productDetailsScreen) {
                composable(navController, destinations)
            }
            with(cartScreen) {
                composable(navController, destinations)
            }
        }
    }
}