@file:OptIn(ExperimentalMaterialApi::class)

package com.firdavs.impl.presentation.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firdavs.common.ui.theme.black200
import com.firdavs.common.ui.theme.grey
import com.firdavs.ecommerce.main.impl.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun FilterOptions(sheetState: BottomSheetState, coroutineScope: CoroutineScope) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(370.dp)
            .background(Color.White, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 20.dp, end = 20.dp),
        ) {
            Button(
                modifier = Modifier
                    .size(37.dp)
                    .align(Alignment.CenterVertically),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.black200),
                onClick = {
                    coroutineScope.launch {
                        if (sheetState.isCollapsed) {
                            sheetState.expand()
                        } else {
                            sheetState.collapse()
                        }
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "Filter Options",
                color = MaterialTheme.colors.black200,
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center
            )
            Button(
                modifier = Modifier
                    .height(37.dp)
                    .width(86.dp)
                    .align(Alignment.CenterVertically),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    coroutineScope.launch {
                        if (sheetState.isCollapsed) {
                            sheetState.expand()
                        } else {
                            sheetState.collapse()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Done",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                )
            }
        }
        Column(Modifier.verticalScroll(rememberScrollState())) {
            ItemsSelectionHeader("Brand")
            val brands = listOf("Apple", "Samsung", "Xiaomi", "Motorola")
            ItemsSelection(brands)

            ItemsSelectionHeader("Price")
            val prices = listOf("$300 - $500", "$500 - $800", "$800 - $1200", "$1200 - $1500")
            ItemsSelection(prices)

            ItemsSelectionHeader("Size")
            val sizes = listOf(
                "4.5 to 5.5 inches",
                "5.5 to 6.5 inches",
                "6.5 to 7.5 inches",
                "7.5 to 8.5 inches"
            )
            ItemsSelection(sizes)
        }
    }
}

@Composable
private fun ItemsSelectionHeader(header: String) {
    Text(
        modifier = Modifier.padding(start = 20.dp, top = 12.dp, bottom = 8.dp),
        text = header,
        color = MaterialTheme.colors.black200,
        fontSize = 18.sp,
        fontWeight = FontWeight(500)
    )
}

@Composable
private fun ItemsSelection(items: List<String>) {
    val text = remember { mutableStateOf("") }
    val isOpen = remember { mutableStateOf(false) }
    val openCloseOfDropDownList: (Boolean) -> Unit = {
        isOpen.value = it
    }
    val userSelectedString: (String) -> Unit = {
        text.value = it
    }
    Box(modifier = Modifier.padding(start = 20.dp)) {
        Column {
            TextField(
                modifier = Modifier
                    .padding(end = 11.dp)
                    .scale(scaleY = 0.8f, scaleX = 1f)
                    .width(337.dp)
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colors.grey,
                        shape = RoundedCornerShape(5.dp)
                    ),
                value = text.value,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                onValueChange = { text.value = it },
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .height(8.dp)
                            .width(16.dp),
                        painter = painterResource(id = R.drawable.ic_arrow_down),
                        contentDescription = null,
                        tint = MaterialTheme.colors.grey
                    )
                },
                shape = RoundedCornerShape(5.dp),
                singleLine = true,
            )
            DropDownList(
                requestToOpen = isOpen.value,
                list = items,
                openCloseOfDropDownList,
                userSelectedString
            )
        }
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .padding(10.dp)
                .clickable(
                    onClick = { isOpen.value = true }
                )
        )
    }
}

@Composable
private fun DropDownList(
    requestToOpen: Boolean = false,
    list: List<String>,
    request: (Boolean) -> Unit,
    selectedString: (String) -> Unit
) {
    DropdownMenu(
        modifier = Modifier.fillMaxWidth(),
        expanded = requestToOpen,
        onDismissRequest = { request(false) },
    ) {
        list.forEach {
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    request(false)
                    selectedString(it)
                }
            ) {
                Text(
                    it, modifier = Modifier
                        .wrapContentWidth()
                )
            }
        }
    }
}