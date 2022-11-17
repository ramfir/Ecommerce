package com.firdavs.common.domain.model

data class ProductDetails(
    val cpu: String,
    val camera: String,
    val capacities: List<String>,
    val colors: List<String>,
    val id: String,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Double,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String
)
