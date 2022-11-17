package com.firdavs.api

import com.firdavs.common.ComposableFeatureEntry

abstract class MainEntry : ComposableFeatureEntry {

    final override val featureRoute = "main"

    fun destination() = featureRoute
}