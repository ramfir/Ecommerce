package com.firdavs.impl.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firdavs.common.ui.theme.black200
import com.firdavs.ecommerce.main.impl.R

@Composable
internal fun BottomBar(modifier: Modifier, onCartClick: () -> Unit, cartProductsCount: Int) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(
                MaterialTheme.colors.black200,
                RoundedCornerShape(30.dp)
            )
            .clickable {},
        verticalAlignment = CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(2f),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .align(CenterVertically)
                    .padding(start = 20.dp, end = 4.dp),
                painter = painterResource(id = R.drawable.ic_dot),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "Explorer",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .clickable(onClick = onCartClick)
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .align(Center)
            ) {
                Icon(
                    modifier = Modifier.align(Center),
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = null,
                    tint = Color.White
                )
                if (cartProductsCount > 0) {
                    Text(
                        modifier = Modifier.align(TopEnd).size(16.dp).background(MaterialTheme.colors.primary, CircleShape),
                        text = "$cartProductsCount",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Icon(
            modifier = Modifier
                .weight(1f)
                .size(18.dp),
            painter = painterResource(id = R.drawable.ic_favorite_not),
            contentDescription = null,
            tint = Color.White
        )
        Icon(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = null,
            tint = Color.White
        )
    }
}