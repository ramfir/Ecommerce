package com.firdavs.product_details.impl.di

import com.firdavs.api.DataProvider
import com.firdavs.api.ProductDetailsProvider
import com.firdavs.common.di.CommonProvider
import com.firdavs.common.di.FeatureScoped
import com.firdavs.product_details.impl.presentation.ProductDetailsViewModel
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [DataProvider::class, CommonProvider::class],
    modules = [ProductDetailsModule::class]
)
interface ProductDetailsComponent : ProductDetailsProvider {

    val viewModel: ProductDetailsViewModel
}