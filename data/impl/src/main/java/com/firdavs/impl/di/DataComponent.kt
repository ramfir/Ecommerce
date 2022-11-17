package com.firdavs.impl.di

import com.firdavs.api.DataProvider
import com.firdavs.common.di.CommonProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CommonProvider::class],
    modules = [DataModule::class]
)
interface DataComponent : DataProvider