package com.firdavs.impl.network.model

import com.firdavs.common.domain.model.HotSaleEntity
import com.squareup.moshi.Json

data class HotSaleDto(
    @Json(name = "id") val id: Int,
    @Json(name = "is_new") val isNew: Boolean?,
    @Json(name = "title") val title: String?,
    @Json(name = "subtitle") val subtitle: String?,
    @Json(name = "picture") val pictureUrl: String?,
    @Json(name = "is_buy") val isBuy: Boolean?
)

fun HotSaleDto.toDomainModel() = HotSaleEntity(
    id = id,
    isNew = isNew ?: false,
    title = title ?: "",
    subtitle = subtitle ?: "",
    pictureUrl = pictureUrl ?: "",
    isBuy = isBuy ?: false
)