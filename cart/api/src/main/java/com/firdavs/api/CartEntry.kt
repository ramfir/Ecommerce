package com.firdavs.api

import com.firdavs.common.ComposableFeatureEntry

abstract class CartEntry : ComposableFeatureEntry {

    final override val featureRoute = "cart"

    fun destination() = featureRoute
}