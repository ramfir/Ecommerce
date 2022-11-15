package com.firdavs.impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
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
internal fun BottomBar(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(
                MaterialTheme.colors.black200,
                RoundedCornerShape(30.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
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
        Icon(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.ic_cart),
            contentDescription = null,
            tint = Color.White
        )
        Icon(
            modifier = Modifier.weight(1f).size(18.dp),
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