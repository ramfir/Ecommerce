package com.firdavs.product_details.impl.di

import com.firdavs.product_details.impl.GetProductDetails
import com.firdavs.product_details.impl.GetProductDetailsUseCase
import dagger.Binds
import dagger.Module

@Module
interface ProductDetailsModule {

    @Binds
    fun bindProductDetails(impl: GetProductDetailsUseCase): GetProductDetails
}