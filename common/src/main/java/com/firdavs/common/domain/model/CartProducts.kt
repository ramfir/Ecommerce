package com.firdavs.common.domain.model

data class CartProducts(
    val basket: List<CartProduct>,
    val delivery: String,
    val id: String,
    val total: Double
)

data class CartProduct(
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)
