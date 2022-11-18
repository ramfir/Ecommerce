package com.firdavs.impl.di

import com.firdavs.impl.domain.GetCartProductsCount
import com.firdavs.impl.domain.GetCartProductsCountUseCase
import com.firdavs.impl.domain.GetProducts
import com.firdavs.impl.domain.GetProductsUseCase
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun bindMain(impl: GetProductsUseCase): GetProducts

    @Binds
    fun bindMainCart(impl: GetCartProductsCountUseCase): GetCartProductsCount
}