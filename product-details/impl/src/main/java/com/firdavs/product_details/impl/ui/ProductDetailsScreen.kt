package com.firdavs.product_details.impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.firdavs.product_details.impl.ProductDetailsViewModel

@Composable
fun ProductDetailsScreen(productId: Int, viewModel: ProductDetailsViewModel, onBackClick: () -> Unit) {
    val productDetails by viewModel.productDetails.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        TopBar(onBackClick)
        productDetails?.let {
            Images(it.images)
            ProductInfo(it)
        }
    }
}