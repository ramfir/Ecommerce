package com.firdavs.impl.network.model

import com.firdavs.common.domain.model.ProductDetails
import com.squareup.moshi.Json

data class ProductDetailsDto(
    @Json(name = "CPU") val cpu: String?,
    @Json(name = "camera") val camera: String?,
    @Json(name = "capacity") val capacities: List<String>?,
    @Json(name = "color") val colors: List<String>?,
    @Json(name = "id") val id: String?,
    @Json(name = "images") val images: List<String>?,
    @Json(name = "isFavorites") val isFavorites: Boolean?,
    @Json(name = "price") val price: Double?,
    @Json(name = "rating") val rating: Double?,
    @Json(name = "sd") val sd: String?,
    @Json(name = "ssd") val ssd: String?,
    @Json(name = "title") val title: String?,
)

fun ProductDetailsDto.toDomainModel() = ProductDetails(
    cpu = cpu ?: "",
    camera = camera ?: "",
    capacities = capacities ?: emptyList(),
    colors = colors ?: emptyList(),
    id = id ?: "1",
    images = images ?: emptyList(),
    isFavorites = isFavorites ?: false,
    price = price ?: 0.0,
    rating = rating ?: 0.0,
    sd = sd ?: "",
    ssd = ssd ?: "",
    title = title ?: ""
)
