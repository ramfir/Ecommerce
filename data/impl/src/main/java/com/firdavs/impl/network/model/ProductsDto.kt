package com.firdavs.impl.network.model

import com.firdavs.common.domain.model.Products
import com.squareup.moshi.Json

data class ProductsDto(
    @Json(name = "home_store") val hotSales: List<HotSaleDto>,
    @Json(name = "best_seller") val bestSellers: List<BestSellerDto>
)

fun ProductsDto.toDomainModel() = Products(
    hotSales = hotSales.map { it.toDomainModel() },
    bestSellers = bestSellers.map { it.toDomainModel() }
)