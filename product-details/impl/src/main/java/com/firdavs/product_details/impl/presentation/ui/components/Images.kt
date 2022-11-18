@file:OptIn(ExperimentalPagerApi::class)

package com.firdavs.product_details.impl.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue

@Composable
internal fun Images(imagesUrl: List<String>) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        modifier = Modifier
            .padding(top = 8.dp),
        state = pagerState,
        count = imagesUrl.size,
        contentPadding = PaddingValues(horizontal = 70.dp, vertical = 16.dp),
    ) { index ->
        val imageUrl = imagesUrl[index]
        ImageItem(
            Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(index).absoluteValue
                    lerp(
                        start = 0.75f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                },
            imageUrl
        )
    }
}

@Composable
private fun ImageItem(modifier: Modifier, imageUrl: String) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 16.dp
    ) {
        Image(
            modifier = Modifier.padding(vertical = 8.dp),
            painter = rememberAsyncImagePainter(
                model = imageUrl
            ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
    }

}