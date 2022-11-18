package com.firdavs.product_details.impl.di

import com.firdavs.api.ProductDetailsEntry
import com.firdavs.common.FeatureEntry
import com.firdavs.common.di.FeatureEntryKey
import com.firdavs.product_details.impl.presentation.ProductDetailsEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ProductDetailsEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(ProductDetailsEntry::class)
    fun productDetailsEntry(entry: ProductDetailsEntryImpl): FeatureEntry
}