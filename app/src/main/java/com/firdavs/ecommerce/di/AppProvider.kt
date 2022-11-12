package com.firdavs.ecommerce.di

import androidx.compose.runtime.compositionLocalOf
import com.firdavs.common.Destinations

interface AppProvider {

    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }