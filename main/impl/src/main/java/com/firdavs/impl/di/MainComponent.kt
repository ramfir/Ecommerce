package com.firdavs.impl.di

import com.firdavs.api.MainProvider
import com.firdavs.common.di.CommonProvider
import com.firdavs.common.di.FeatureScoped
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [CommonProvider::class],
    modules = [MainEntryModule::class]
)
interface MainComponent : MainProvider {
}