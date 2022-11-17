package com.firdavs.impl.di

import com.firdavs.impl.GetCartProductsCount
import com.firdavs.impl.GetCartProductsCountUseCase
import com.firdavs.impl.GetProducts
import com.firdavs.impl.GetProductsUseCase
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun bindMain(impl: GetProductsUseCase): GetProducts

    @Binds
    fun bindMainCart(impl: GetCartProductsCountUseCase): GetCartProductsCount
}