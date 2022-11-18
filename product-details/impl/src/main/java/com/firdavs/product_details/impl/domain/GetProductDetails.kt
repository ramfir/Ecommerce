package com.firdavs.product_details.impl.domain

import com.firdavs.common.di.CommonModule.IO
import com.firdavs.common.domain.ProductsRepository
import com.firdavs.common.domain.model.ProductDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Named

interface GetProductDetails {

    operator fun invoke(): Flow<ProductDetails>
}

class GetProductDetailsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository,
    @Named(IO) private val ioDispatcher: CoroutineDispatcher
) : GetProductDetails {

    override fun invoke(): Flow<ProductDetails> =
        productsRepository.getProductDetails().flowOn(ioDispatcher)
}