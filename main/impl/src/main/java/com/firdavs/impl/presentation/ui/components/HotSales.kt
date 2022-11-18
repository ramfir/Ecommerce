@file:OptIn(ExperimentalPagerApi::class)

package com.firdavs.impl.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.firdavs.common.domain.model.HotSaleEntity
import com.firdavs.common.ui.theme.black200
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
internal fun HotSales(hotSales: List<HotSaleEntity>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 17.dp, end = 35.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Hot Sales",
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
        val pagerState = rememberPagerState()
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            state = pagerState,
            count = hotSales.size
        ) { index ->
            val hotSale = hotSales[index]
            HotSaleItem(hotSale)
        }
    }
}

@Composable
private fun HotSaleItem(hotSale: HotSaleEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(182.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = hotSale.pictureUrl
            ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0F to Color.Transparent,
                        .5F to Color.Black.copy(alpha = 0.5F),
                        1F to Color.Black.copy(alpha = 0.8F)
                    )
                )
        )
        Column(
            modifier = Modifier.padding(start = 25.dp, top = 21.dp)
        ) {
            if (hotSale.isNew) {
                Box(
                    modifier = Modifier
                        .size(37.dp)
                        .background(MaterialTheme.colors.primary, CircleShape)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(8.dp),
                        text = "New",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight(700)
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(
                        top = if (hotSale.isNew) 18.dp else 55.dp
                    ),
                text = hotSale.title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight(700)
            )
            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = hotSale.subtitle,
                color = Color.White,
                fontSize = 12.sp,
            )
            if (hotSale.isBuy) {
                Button(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .height(23.dp)
                        .width(98.dp),
                    shape = RoundedCornerShape(5.dp),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Buy now!",
                        color = MaterialTheme.colors.black200,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}