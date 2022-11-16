package com.firdavs.impl

import com.firdavs.common.domain.ProductsRepository
import com.firdavs.common.domain.model.ProductDetails
import com.firdavs.common.domain.model.Products
import com.firdavs.impl.network.EcommerceApi
import com.firdavs.impl.network.model.toDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.UnknownHostException
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val networkApi: EcommerceApi
) : ProductsRepository {

    override fun getProducts(): Flow<Products> =
        flow {
            val products = getProductsFromNetwork()
            if (products != null) {
                emit(products)
            }
        }

    internal suspend fun getProductsFromNetwork(): Products? {
        val networkProducts = try {
            networkApi.getProducts()
        } catch (e: UnknownHostException) {
            return null
        }
        val domainProducts = networkProducts.toDomainModel()
        return domainProducts
    }

    override fun getProductDetails(): Flow<ProductDetails> =
        flow {
            val productDetails = getProductDetailsFromNetwork()
            if (productDetails != null) {
                emit(productDetails)
            }
        }

    internal suspend fun getProductDetailsFromNetwork(): ProductDetails? {
        val networkProductDetails = try {
            networkApi.getProductDetails()
        } catch (e: UnknownHostException) {
            return null
        }
        val domainProductDetails = networkProductDetails.toDomainModel()
        return domainProductDetails
    }
}