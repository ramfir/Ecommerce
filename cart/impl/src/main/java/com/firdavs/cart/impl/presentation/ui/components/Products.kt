package com.firdavs.cart.impl.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.firdavs.common.domain.model.CartProduct
import com.firdavs.common.domain.model.CartProducts
import com.firdavs.common.ui.theme.*
import com.firdavs.ecommerce.cart.impl.R.*

@Composable
internal fun Products(cartProducts: CartProducts) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.black200, RoundedCornerShape(30.dp))
    ) {
        LazyColumn(
            Modifier.padding(start = 32.dp, end = 32.dp, top = 52.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(cartProducts.basket) { item: CartProduct ->
                CartProductItem(item)
            }
        }
        Spacer(Modifier.weight(1f))
        Total(cartProducts.total, cartProducts.delivery)
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp)
                .padding(top = 27.dp, bottom = 34.dp)
                .height(44.dp),
            onClick = {},
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Checkout",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}

@Composable
private fun CartProductItem(cartProduct: CartProduct) {
    Row(Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .size(88.dp)
                .background(Color.White, RoundedCornerShape(10.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = cartProduct.image
                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
        }
        Column(Modifier.padding(start = 8.dp, end = 16.dp)) {
            Text(
                modifier = Modifier.width(150.dp),
                text = cartProduct.title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight(500)
            )
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = "$${cartProduct.price}",
                color = MaterialTheme.colors.primary,
                fontSize = 20.sp,
                fontWeight = FontWeight(500)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            Modifier
                .background(MaterialTheme.colors.black500, RoundedCornerShape(26.dp))
                .size(width = 26.dp, height = 78.dp)
                .align(CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier,
                text = "-\n2\n+",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center
            )
        }
        Icon(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(CenterVertically),
            painter = painterResource(drawable.ic_basket),
            contentDescription = null,
            tint = Color(0xFF36364D)
        )
    }
}

@Composable
private fun Total(total: Double, delivery: String) {
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(MaterialTheme.colors.grey100)
            .padding(vertical = 16.dp)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 35.dp, top = 15.dp)
        ) {
            Text(
                modifier = Modifier.width(100.dp),
                text = "Total",
                color = Color.White,
                fontSize = 15.sp,
            )
            Spacer(Modifier.weight(1f))
            Text(
                modifier = Modifier.width(100.dp),
                text = "$${"%,d".format(total.toInt())} us",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
        }
        Row(Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 35.dp, top = 12.dp)) {
            Text(
                text = "Delivery",
                color = Color.White,
                fontSize = 15.sp
            )
            Spacer(Modifier.weight(1f))
            Text(
                modifier = Modifier.width(100.dp),
                text = delivery,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
        }
        Box(modifier = Modifier
            .padding(top = 26.dp)
            .fillMaxWidth()
            .height(1.dp)
            .background(MaterialTheme.colors.grey100)
        )
    }
}