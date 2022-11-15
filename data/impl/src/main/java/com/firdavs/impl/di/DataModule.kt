package com.firdavs.impl.di

import com.firdavs.common.domain.ProductsRepository
import com.firdavs.impl.ProductsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
interface DataModule {

    @Binds
    fun productsRepository(impl: ProductsRepositoryImpl): ProductsRepository
}