package com.firdavs.impl.domain

import com.firdavs.common.di.CommonModule
import com.firdavs.common.domain.ProductsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

interface GetCartProductsCount {

    operator fun invoke(): Flow<Int>
}

class GetCartProductsCountUseCase @Inject constructor(
    private val productsRepository: ProductsRepository,
    @Named(CommonModule.IO) private val ioDispatcher: CoroutineDispatcher
): GetCartProductsCount {

    override fun invoke(): Flow<Int> =
        productsRepository
            .getCartProducts()
            .map { it.basket.size }
            .flowOn(ioDispatcher)
}