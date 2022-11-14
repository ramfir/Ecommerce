package com.firdavs.common.domain

data class HotSaleEntity(
    val id: Int,
    val isNew: Boolean,
    val title: String,
    val subtitle: String,
    val pictureUrl: String,
    val isBuy: Boolean
)
