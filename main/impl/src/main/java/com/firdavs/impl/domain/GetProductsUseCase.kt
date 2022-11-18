package com.firdavs.impl.domain

import com.firdavs.common.di.CommonModule.IO
import com.firdavs.common.domain.ProductsRepository
import com.firdavs.common.domain.model.Products
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Named

interface GetProducts {

    operator fun invoke(): Flow<Products>
}

class GetProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository,
    @Named(IO) private val ioDispatcher: CoroutineDispatcher
) : GetProducts {

    override fun invoke(): Flow<Products> =
        productsRepository.getProducts().flowOn(ioDispatcher)
}