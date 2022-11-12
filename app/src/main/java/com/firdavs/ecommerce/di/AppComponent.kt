package com.firdavs.ecommerce.di

import com.firdavs.common.di.CommonProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CommonProvider::class
    ],
    modules = [NavigationModule::class]
)
interface AppComponent : AppProvider