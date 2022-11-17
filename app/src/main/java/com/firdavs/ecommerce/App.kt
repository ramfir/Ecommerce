package com.firdavs.ecommerce

import android.app.Application
import com.firdavs.common.di.DaggerCommonComponent
import com.firdavs.ecommerce.di.AppProvider
import com.firdavs.ecommerce.di.DaggerAppComponent
import com.firdavs.impl.di.DaggerDataComponent

class App : Application() {

    lateinit var appProvider: AppProvider
        private set

    override fun onCreate() {
        super.onCreate()

        val commonProvider = DaggerCommonComponent.factory().create(this)
        appProvider = DaggerAppComponent.builder()
            .commonProvider(commonProvider)
            .dataProvider(DaggerDataComponent.builder().commonProvider(commonProvider).build())
            .build()
    }
}

val Application.appProvider: AppProvider
    get() = (this as App).appProvider