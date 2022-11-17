package com.firdavs.ecommerce.di

import androidx.compose.runtime.compositionLocalOf
import com.firdavs.api.DataProvider
import com.firdavs.common.Destinations
import com.firdavs.common.di.CommonProvider

interface AppProvider : DataProvider, CommonProvider {

    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }