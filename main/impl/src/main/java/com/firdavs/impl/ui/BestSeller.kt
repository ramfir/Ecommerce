package com.firdavs.impl.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.firdavs.common.domain.BestSellerEntity
import com.firdavs.common.ui.theme.black200
import com.firdavs.common.ui.theme.grey200
import com.firdavs.ecommerce.main.impl.R

@Composable
internal fun BestSeller(bestSellers: List<BestSellerEntity>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 17.dp, end = 35.dp, bottom = 70.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Best Seller",
                fontSize = 25.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colors.black200
            )
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = "see more",
                fontSize = 15.sp,
                color = MaterialTheme.colors.primary
            )
        }
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(bestSellers) { bestSeller ->
                BestSellerItem(bestSeller)
            }
        }
    }
}

@Composable
private fun BestSellerItem(bestSeller: BestSellerEntity) {
    var isFavorite by remember { mutableStateOf(bestSeller.isFavorites) }
    Column(
        modifier = Modifier
            .size(height = 215.dp, width = 171.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(8.dp)
    ) {
        Box {
            Image(
                modifier = Modifier
                    .size(width = 150.dp, height = 150.dp),
                painter = rememberAsyncImagePainter(
                    model = bestSeller.pictureUrl
                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
            Card(
                modifier = Modifier
                    .size(25.dp)
                    .background(Color.White, CircleShape)
                    .padding(8.dp)
                    .align(Alignment.TopEnd)
                    .clickable { isFavorite = isFavorite.not() },
                elevation = 16.dp
            ) {
                Image(
                    painter = painterResource(
                        id = if (isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_not
                    ),
                    contentDescription = null
                )
            }
        }
        Row(modifier = Modifier.padding(start = 10.dp)) {
            Text(
                text = "$${"%,d".format(bestSeller.discountPrice.toInt())}",
                color = MaterialTheme.colors.black200,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 2.dp)
                    .align(Alignment.Bottom),
                text = "$${"%,d".format(bestSeller.priceWithoutDiscount.toInt())}",
                color = MaterialTheme.colors.grey200,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
        }
        Text(
            modifier = Modifier.padding(top = 5.dp, start = 10.dp),
            text = bestSeller.title,
            color = MaterialTheme.colors.black200,
            fontSize = 10.sp
        )
    }
}