package com.firdavs.product_details.impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firdavs.common.domain.model.ProductDetails
import com.firdavs.common.ui.theme.black200
import com.firdavs.common.ui.theme.grey
import com.firdavs.common.ui.theme.grey500
import com.firdavs.common.ui.theme.yellow200
import com.firdavs.ecommerce.product_details.impl.R

@Composable
internal fun ProductInfo(product: ProductDetails) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(vertical = 18.dp)
            .padding(horizontal = 28.dp)
    ) {
        Header(product)
        Tabs()
        Characteristics(product)
        ColorAndCapacity(product)
        Spacer(modifier = Modifier.weight(1f))
        AddButton(product)
    }
}

@Composable
private fun Header(product: ProductDetails) {
    var isFavorite by remember { mutableStateOf(product.isFavorites) }
    Row {
        Column(Modifier.weight(1f)) {
            Text(
                text = product.title,
                color = MaterialTheme.colors.black200,
                fontSize = 20.sp,
                fontWeight = FontWeight(500)
            )
            LazyRow(
                modifier = Modifier.padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(product.rating.toInt()) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null,
                        tint = MaterialTheme.colors.yellow200
                    )
                }
            }
        }
        Button(
            modifier = Modifier
                .size(35.dp)
                .align(Alignment.Top),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.black200),
            onClick = { isFavorite = isFavorite.not() }
        ) {
            Icon(
                painter = painterResource(
                    id = if (isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_not
                ),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
private fun Tabs() {
    val tabs = listOf("Shop", "Details", "Features")
    var selectedTab by remember { mutableStateOf(tabs[0]) }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 22.dp)
    ) {
        tabs.forEach { tabItem ->
            TabItem(
                Modifier.weight(1f),
                tabItem,
                selectedTab == tabItem
            ) {
                selectedTab = it
            }
        }
    }
}

@Composable
private fun TabItem(
    modifier: Modifier,
    tabItem: String,
    isSelected: Boolean,
    onTabClick: (String) -> Unit
) {
    Column(modifier
        .clickable { onTabClick(tabItem) }
    ) {
        Text(
            modifier = Modifier.align(CenterHorizontally),
            text = tabItem,
            fontSize = 16.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight(400),
            color = if (isSelected) MaterialTheme.colors.black200 else MaterialTheme.colors.grey,
            textAlign = TextAlign.Center
        )
        if (isSelected) {
            Box(
                Modifier
                    .padding(top = 8.dp)
                    .height(3.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
            )
        }
    }
}

@Composable
private fun Characteristics(product: ProductDetails) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        CharacteristicItem(Modifier.weight(1f), painterResource(R.drawable.ic_cpu), product.cpu)
        CharacteristicItem(Modifier.weight(1f), painterResource(R.drawable.ic_camera), product.camera)
        CharacteristicItem(Modifier.weight(1f), painterResource(R.drawable.ic_ssd), product.ssd)
        CharacteristicItem(Modifier.weight(1f), painterResource(R.drawable.ic_sd), product.sd)
    }
}

@Composable
private fun CharacteristicItem(modifier: Modifier, image: Painter, title: String) {
    Column(
        modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .align(CenterHorizontally)
                .size(28.dp),
            painter = image,
            contentDescription = null,
            tint = MaterialTheme.colors.grey500
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            text = title,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 10.sp
        )
    }
}

@Composable
private fun ColorAndCapacity(product: ProductDetails) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Select color and capacity",
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            color = MaterialTheme.colors.black200
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            val colors = product.colors.map { it.color }
            var selectedColor by remember { mutableStateOf(colors[0]) }

            colors.forEach {
                ColorItem(it, selectedColor == it) {
                    selectedColor = it
                }
            }

            Spacer(modifier = Modifier.width(24.dp))

            val capacities = product.capacities.map { "$it gb" }
            var selectedCapacity by remember { mutableStateOf(capacities[0]) }

            capacities.forEach {
                CapacityItem(it, selectedCapacity == it) {
                    selectedCapacity = it
                }
            }
        }
    }
}

@Composable
fun ColorItem(color: Color, isSelected: Boolean, onColorClick: (Color) -> Unit) {
    Box(
        Modifier
            .padding(end = 16.dp)
            .size(40.dp)
            .background(color, CircleShape)
            .clickable { onColorClick(color) }
    ) {
        if (isSelected) {
            Icon(
                modifier = Modifier.align(Center),
                painter = painterResource(R.drawable.ic_done),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
private fun CapacityItem(capacity: String, isSelected: Boolean, onCapacityClick: (String) -> Unit) {
    Box(
        Modifier
            .padding(end = 16.dp)
            .size(width = 70.dp, height = 30.dp)
            .background(
                color = if (isSelected) MaterialTheme.colors.primary else Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onCapacityClick(capacity) }
    ) {
        Text(
            modifier = Modifier.align(Center),
            text = if (isSelected) capacity.uppercase() else capacity,
            color = if (isSelected) Color.White else Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun AddButton(product: ProductDetails) {
    Button(
        modifier = Modifier.fillMaxWidth().height(44.dp),
        onClick = {},
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
    ) {
        Row(Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Add to Cart",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.weight(1f),
                text = "$${"%,d".format(product.price.toInt())}",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

val String.color
    get() = Color(android.graphics.Color.parseColor(this))