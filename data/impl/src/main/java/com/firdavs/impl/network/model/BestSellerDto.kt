package com.firdavs.impl.network.model

import com.firdavs.common.domain.model.BestSellerEntity
import com.squareup.moshi.Json

data class BestSellerDto(
    val id: Int,
    @Json(name = "is_favorites") val isFavorites: Boolean?,
    val title: String?,
    @Json(name = "price_without_discount") val priceWithoutDiscount: Double?,
    @Json(name = "discount_price") val discountPrice: Double?,
    @Json(name = "picture") val pictureUrl: String?
)

fun BestSellerDto.toDomainModel() = BestSellerEntity(
    id = id,
    isFavorites = isFavorites ?: false,
    title = title ?: "",
    priceWithoutDiscount = priceWithoutDiscount ?: 0.0,
    discountPrice = discountPrice ?: 0.0,
    pictureUrl = pictureUrl ?: ""
)