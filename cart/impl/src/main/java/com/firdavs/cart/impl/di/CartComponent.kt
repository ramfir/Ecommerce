package com.firdavs.cart.impl.di

import com.firdavs.api.CartProvider
import com.firdavs.api.DataProvider
import com.firdavs.cart.impl.presentation.CartViewModel
import com.firdavs.common.di.CommonProvider
import com.firdavs.common.di.FeatureScoped
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [DataProvider::class, CommonProvider::class],
    modules = [CartModule::class]
)
interface CartComponent : CartProvider {

    val viewModel: CartViewModel
}