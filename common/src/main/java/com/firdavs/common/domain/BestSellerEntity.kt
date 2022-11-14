package com.firdavs.common.domain

data class BestSellerEntity(
    val id: Int,
    val isFavorites: Boolean,
    val title: String,
    val priceWithoutDiscount: Double,
    val discountPrice: Double,
    val pictureUrl: String
)
