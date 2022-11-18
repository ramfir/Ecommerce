package com.firdavs.cart.impl.di

import com.firdavs.cart.impl.domain.GetCartProducts
import com.firdavs.cart.impl.domain.GetCartProductsUseCase
import dagger.Binds
import dagger.Module

@Module
interface CartModule {

    @Binds
    fun bindCart(impl: GetCartProductsUseCase): GetCartProducts
}