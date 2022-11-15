package com.firdavs.ecommerce.di

import androidx.compose.runtime.compositionLocalOf
import com.firdavs.common.Destinations
import com.firdavs.common.di.CommonProvider

interface AppProvider : CommonProvider {

    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }