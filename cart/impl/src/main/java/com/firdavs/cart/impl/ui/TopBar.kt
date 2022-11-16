package com.firdavs.cart.impl.ui

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
import com.firdavs.ecommerce.cart.impl.R

@Composable
internal fun TopBar() {
    Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        Button(
            modifier = Modifier
                .size(37.dp)
                .align(Alignment.CenterVertically),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.black200),
            onClick = {}
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
                .padding(end = 8.dp)
                .align(Alignment.CenterVertically),
            text = "Add address",
            color = MaterialTheme.colors.black200,
            fontSize = 15.sp,
            fontWeight = FontWeight(500),
            textAlign = TextAlign.End
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
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}