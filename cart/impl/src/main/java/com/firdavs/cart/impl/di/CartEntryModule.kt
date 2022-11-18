package com.firdavs.cart.impl.di

import com.firdavs.api.CartEntry
import com.firdavs.common.FeatureEntry
import com.firdavs.common.di.FeatureEntryKey
import com.firdavs.cart.impl.presentation.CartEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface CartEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(CartEntry::class)
    fun mainEntry(entry: CartEntryImpl): FeatureEntry
}