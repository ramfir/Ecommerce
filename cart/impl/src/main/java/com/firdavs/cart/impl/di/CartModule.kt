package com.firdavs.cart.impl.di

import com.firdavs.cart.impl.GetCartProducts
import com.firdavs.cart.impl.GetCartProductsUseCase
import dagger.Binds
import dagger.Module

@Module
interface CartModule {

    @Binds
    fun bindCart(impl: GetCartProductsUseCase): GetCartProducts
}