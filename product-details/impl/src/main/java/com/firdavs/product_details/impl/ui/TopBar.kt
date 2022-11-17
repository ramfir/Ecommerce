package com.firdavs.product_details.impl.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firdavs.common.ui.theme.black200
import com.firdavs.ecommerce.product_details.impl.R

@Composable
internal fun TopBar(onBackClick: () -> Unit) {
    Row(Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
        Button(
            modifier = Modifier
                .size(37.dp)
                .align(Alignment.CenterVertically),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.black200),
            onClick = onBackClick
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null,
                tint = Color.White
            )
        }
        Text(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = "Product Details",
            color = MaterialTheme.colors.black200,
            fontSize = 18.sp,
            fontWeight = FontWeight(500),
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier
                .size(37.dp)
                .align(Alignment.CenterVertically),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
            onClick = {}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}