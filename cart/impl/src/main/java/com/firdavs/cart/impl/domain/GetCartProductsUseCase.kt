package com.firdavs.cart.impl.domain

import com.firdavs.common.di.CommonModule
import com.firdavs.common.domain.ProductsRepository
import com.firdavs.common.domain.model.CartProducts
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Named

interface GetCartProducts {

    operator fun invoke(): Flow<CartProducts>
}

class GetCartProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository,
    @Named(CommonModule.IO) private val ioDispatcher: CoroutineDispatcher
) : GetCartProducts {

    override fun invoke(): Flow<CartProducts> =
        productsRepository.getCartProducts().flowOn(ioDispatcher)
}