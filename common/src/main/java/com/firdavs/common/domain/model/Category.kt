package com.firdavs.common.domain.model

data class Category(
    val id: Int,
    val name: String,
    val iconId: Int
)

data class CategoryList(
    val categories: List<Category>,
    val selectedId: Int
)
