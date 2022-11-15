package com.firdavs.impl.di

import com.firdavs.impl.GetProducts
import com.firdavs.impl.GetProductsUseCase
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun bindMain(impl: GetProductsUseCase): GetProducts
}