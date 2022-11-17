package com.firdavs.impl.network.model

import com.firdavs.common.domain.model.CartProduct
import com.firdavs.common.domain.model.CartProducts
import com.squareup.moshi.Json

data class CartProductsDto(
    @Json(name = "basket") val basket: List<CartProductDto>?,
    @Json(name = "delivery") val delivery: String?,
    @Json(name = "id") val id: String?,
    @Json(name = "total") val total: Double?,
)

data class CartProductDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "images") val image: String?,
    @Json(name = "price") val price: Double?,
    @Json(name = "title") val title: String?,
)

fun CartProductsDto.toDomainModel() = CartProducts(
    basket = basket?.map { it.toDomainModel() } ?: emptyList<CartProduct>(),
    delivery = delivery ?: "",
    id = id ?: "1",
    total = total ?: 0.0
)

fun CartProductDto.toDomainModel() = CartProduct(
    id = id ?: 1,
    image = image ?: "",
    price = price ?: 0.0,
    title = title ?: ""
)


