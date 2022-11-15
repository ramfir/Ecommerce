package com.firdavs.impl.di

import com.firdavs.api.MainProvider
import com.firdavs.common.di.CommonProvider
import com.firdavs.common.di.FeatureScoped
import com.firdavs.impl.MainViewModel
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [CommonProvider::class],
    modules = [MainModule::class]
)
interface MainComponent : MainProvider {

    val viewModel: MainViewModel
}