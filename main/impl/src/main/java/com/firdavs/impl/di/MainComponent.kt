package com.firdavs.impl.di

import com.firdavs.api.DataProvider
import com.firdavs.api.MainProvider
import com.firdavs.common.di.CommonProvider
import com.firdavs.common.di.FeatureScoped
import com.firdavs.impl.presentation.MainViewModel
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [DataProvider::class, CommonProvider::class],
    modules = [MainModule::class]
)
interface MainComponent : MainProvider {

    val viewModel: MainViewModel
}