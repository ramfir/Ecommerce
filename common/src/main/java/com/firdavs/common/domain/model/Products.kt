package com.firdavs.common.domain.model

data class Products(
    val hotSales: List<HotSaleEntity>,
    val bestSellers: List<BestSellerEntity>
)
