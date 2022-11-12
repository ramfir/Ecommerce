package com.firdavs.impl.di

import com.firdavs.api.MainEntry
import com.firdavs.common.FeatureEntry
import com.firdavs.common.di.FeatureEntryKey
import com.firdavs.impl.MainEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface MainEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(MainEntry::class)
    fun mainEntry(entry: MainEntryImpl): FeatureEntry
}