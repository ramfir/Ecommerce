package com.firdavs.ecommerce.di

import com.firdavs.impl.di.MainEntryModule
import dagger.Module

@Module(
    includes = [
        MainEntryModule::class
    ]
)
interface NavigationModule