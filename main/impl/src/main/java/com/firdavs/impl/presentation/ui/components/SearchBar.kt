package com.firdavs.impl.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.firdavs.common.ui.theme.black200alpha25
import com.firdavs.ecommerce.main.impl.R

@Composable
internal fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .padding(top = 35.dp)
    ) {
        var textValue by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .weight(1f)
                .padding(end = 11.dp)
                .scale(scaleY = 0.8f, scaleX = 1f),
            value = textValue,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            onValueChange = { textValue = it },
            placeholder = {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "Search",
                    color = MaterialTheme.colors.black200alpha25
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary
                )
            },
            shape = RoundedCornerShape(50.dp),
            singleLine = true
        )
        Box(
            modifier = Modifier
                .size(34.dp)
                .background(MaterialTheme.colors.primary, CircleShape)
                .padding(10.dp)
                .align(Alignment.CenterVertically)
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = R.drawable.ic_qr),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}