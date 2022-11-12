package com.firdavs.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.firdavs.api.MainEntry
import com.firdavs.common.Destinations
import com.firdavs.impl.ui.MainScreen
import javax.inject.Inject

class MainEntryImpl @Inject constructor() : MainEntry() {

    @Composable
    override fun Composable(
        navController: NavController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
    ) {
        MainScreen()
    }
}