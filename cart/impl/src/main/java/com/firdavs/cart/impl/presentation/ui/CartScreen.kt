package com.firdavs.cart.impl.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firdavs.cart.impl.presentation.CartViewModel
import com.firdavs.cart.impl.presentation.ui.components.Products
import com.firdavs.cart.impl.presentation.ui.components.TopBar
import com.firdavs.common.ui.theme.black200

@Composable
fun CartScreen(
    viewModel: CartViewModel,
    onBackClick: () -> Unit
) {
    val cartProducts by viewModel.cartProducts.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
    ) {
        TopBar(onBackClick)
        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .padding(vertical = 44.dp),
            text = "My Cart",
            color = MaterialTheme.colors.black200,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
        cartProducts?.let { Products(it) }
    }
}