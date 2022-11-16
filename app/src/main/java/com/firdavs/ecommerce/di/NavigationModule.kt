package com.firdavs.ecommerce.di

import com.firdavs.cart.impl.di.CartEntryModule
import com.firdavs.impl.di.MainEntryModule
import com.firdavs.product_details.impl.di.ProductDetailsEntryModule
import dagger.Module

@Module(
    includes = [
        MainEntryModule::class,
        ProductDetailsEntryModule::class,
        CartEntryModule::class
    ]
)
interface NavigationModule