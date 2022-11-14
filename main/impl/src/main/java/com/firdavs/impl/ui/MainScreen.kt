@file:OptIn(ExperimentalMaterialApi::class)

package com.firdavs.impl.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.firdavs.common.domain.BestSellerEntity
import com.firdavs.common.domain.Category
import com.firdavs.common.domain.CategoryList
import com.firdavs.common.domain.HotSaleEntity
import com.firdavs.common.ui.theme.*
import com.firdavs.ecommerce.main.impl.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun MainScreen() {
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            FilterOptions(sheetState, coroutineScope)
        },
        sheetPeekHeight = 0.dp,
        sheetBackgroundColor = Color.Transparent,
        sheetElevation = 50.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TopBar(sheetState, coroutineScope)
            Categories()
            SearchBar()
            HotSales()
            BestSeller()
        }
    }

}

@Composable
private fun TopBar(sheetState: BottomSheetState, coroutineScope: CoroutineScope) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 11.dp)
                    .align(CenterVertically),
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = null,
                tint = MaterialTheme.colors.primary

            )
            Text(
                modifier = Modifier
                    .padding(end = 8.dp),
                text = stringResource(R.string.zihuatanejo),
                fontSize = 15.sp,
                style = MaterialTheme.typography.h4.copy(
                    shadow = Shadow(
                        color = MaterialTheme.colors.black25alpha,
                        offset = Offset(x = 2f, y = 4f),
                        blurRadius = 0.1f
                    )
                ),
                color = MaterialTheme.colors.black200
            )
            Icon(
                modifier = Modifier.align(CenterVertically),
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = null,
                tint = MaterialTheme.colors.grey
            )
        }
        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 35.dp)
                .clickable {
                    coroutineScope.launch {
                        if (sheetState.isCollapsed) {
                            sheetState.expand()
                        } else {
                            sheetState.collapse()
                        }
                    }
                },
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = null,
            tint = MaterialTheme.colors.black200
        )
    }
}

@Composable
private fun Categories() {
    var categories by remember {
        mutableStateOf(
            CategoryList(
                categories = listOf(
                    Category(1, "Phones", R.drawable.ic_phone),
                    Category(2, "Computer", R.drawable.ic_computer),
                    Category(3, "Health", R.drawable.ic_health),
                    Category(4, "Books", R.drawable.ic_books),
                    Category(5, "Phones", R.drawable.ic_phone),
                    Category(6, "Computer", R.drawable.ic_computer),
                    Category(7, "Health", R.drawable.ic_health),
                    Category(8, "Books", R.drawable.ic_books),
                ),
                selectedId = 1
            )

        )
    }
    Column(
        modifier = Modifier.padding(top = 18.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 17.dp, end = 35.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.select_category),
                fontSize = 25.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colors.black200
            )
            Text(
                modifier = Modifier.align(CenterVertically),
                text = stringResource(R.string.view_all),
                fontSize = 15.sp,
                color = MaterialTheme.colors.primary
            )
        }

        LazyRow(
            modifier = Modifier.padding(top = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(23.dp),
            contentPadding = PaddingValues(horizontal = 27.dp)
        ) {
            items(categories.categories) { category ->
                CategoryItem(category, category.id == categories.selectedId) {
                    categories = categories.copy(selectedId = category.id)
                }
            }
        }
    }
}

@Composable
private fun CategoryItem(category: Category, isSelected: Boolean, onCategoryClick: () -> Unit) {
    Column {
        Box(
            modifier = Modifier
                .size(71.dp)
                .background(
                    color = if (isSelected) MaterialTheme.colors.primary else Color.White,
                    shape = CircleShape
                )
                .clickable { onCategoryClick() }
                .padding(16.dp)
        ) {
            Icon(
                modifier = Modifier.align(Center),
                painter = painterResource(id = category.iconId),
                contentDescription = null,
                tint = if (isSelected) Color.White else MaterialTheme.colors.grey
            )
        }
        Text(
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 7.dp),
            text = category.name,
            style = MaterialTheme.typography.h4.copy(
                shadow = if (isSelected) Shadow(
                    color = MaterialTheme.colors.black25alpha,
                    offset = Offset(x = 2f, y = 4f),
                    blurRadius = 0.1f
                ) else null
            ),
            color = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.black200,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun SearchBar() {
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
                    modifier = Modifier.align(CenterVertically),
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
                .align(CenterVertically)
        ) {
            Icon(
                modifier = Modifier.align(Center),
                painter = painterResource(id = R.drawable.ic_qr),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun HotSales() {
    val hotSales by remember {
        mutableStateOf(
            listOf(
                HotSaleEntity(1,
                              true,
                              "Iphone 12",
                              "Súper. Mega. Rápido.",
                              "https://img.ibxk.com.br/2020/09/23/23104013057475.jpg?w=1120&h=420&mode=crop&scale=both",
                              true),
                HotSaleEntity(2,
                              false,
                              "Samsung Galaxy A71",
                              "Súper. Mega. Rápido.",
                              "https://cdn-2.tstatic.net/kupang/foto/bank/images/pre-order-samsung-galaxy-a71-laris-manis-inilah-rekomendasi-ponsel-harga-rp-6-jutaan.jpg",
                              true),
                HotSaleEntity(3,
                              true,
                              "Xiaomi Mi 11 ultra",
                              "Súper. Mega. Rápido.",
                              "https://static.digit.in/default/942998b8b4d3554a6259aeb1a0124384dbe0d4d5.jpeg",
                              true),
            )
        )
    }
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
                modifier = Modifier.align(CenterVertically),
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
                .background(Brush.verticalGradient(
                    0F to Color.Transparent,
                    .5F to Color.Black.copy(alpha = 0.5F),
                    1F to Color.Black.copy(alpha = 0.8F)
                ))
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
                            .align(Center)
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

@Composable
private fun BestSeller() {
    var bestSellers by remember {
        mutableStateOf(
            listOf(
                BestSellerEntity(1,
                                 true,
                                 "Samsung Galaxy s20 Ultra",
                                 1047.toDouble(),
                                 1500.toDouble(),
                                 "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"),
                BestSellerEntity(2,
                                 false,
                                 "Xiaomi Mi 10 Pro",
                                 300.toDouble(),
                                 1500.toDouble(),
                                 "https://mi92.ru/wp-content/uploads/2020/03/smartfon-xiaomi-mi-10-pro-12-256gb-global-version-starry-blue-sinij-1.jpg"),
                BestSellerEntity(3,
                                 false,
                                 "Samsung Note 20 Ultra",
                                 1047.toDouble(),
                                 1500.toDouble(),
                                 "https://opt-1739925.ssl.1c-bitrix-cdn.ru/upload/iblock/c01/c014d088c28d45b606ed8c58e5817172.jpg?160405904823488"),
                BestSellerEntity(4,
                                 true,
                                 "Motorola One Edge",
                                 1047.toDouble(),
                                 1500.toDouble(),
                                 "https://www.benchmark.rs/assets/img/news/edge1.jpg"),
                BestSellerEntity(5,
                                 true,
                                 "Samsung Galaxy s20 Ultra",
                                 1047.toDouble(),
                                 1500.toDouble(),
                                 "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"),
                BestSellerEntity(6,
                                 false,
                                 "Xiaomi Mi 10 Pro",
                                 300.toDouble(),
                                 1500.toDouble(),
                                 "https://mi92.ru/wp-content/uploads/2020/03/smartfon-xiaomi-mi-10-pro-12-256gb-global-version-starry-blue-sinij-1.jpg"),
                BestSellerEntity(7,
                                 false,
                                 "Samsung Note 20 Ultra",
                                 1047.toDouble(),
                                 1500.toDouble(),
                                 "https://opt-1739925.ssl.1c-bitrix-cdn.ru/upload/iblock/c01/c014d088c28d45b606ed8c58e5817172.jpg?160405904823488"),

                )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 17.dp, end = 35.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Best Seller",
                fontSize = 25.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colors.black200
            )
            Text(
                modifier = Modifier.align(CenterVertically),
                text = "see more",
                fontSize = 15.sp,
                color = MaterialTheme.colors.primary
            )
        }
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            columns = GridCells.Fixed(2)
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
            .size(height = 227.dp, width = 181.dp)
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
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
                    .align(TopEnd)
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
        Row(modifier = Modifier.padding(start = 21.dp)) {
            Text(
                text = "$${bestSeller.discountPrice}",
                color = MaterialTheme.colors.black200,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 2.dp)
                    .align(Bottom),
                text = "$${bestSeller.priceWithoutDiscount}",
                color = MaterialTheme.colors.grey200,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
        }
        Text(
            modifier = Modifier.padding(top = 5.dp, start = 21.dp),
            text = bestSeller.title,
            color = MaterialTheme.colors.black200,
            fontSize = 10.sp
        )
    }
}

@Composable
private fun FilterOptions(sheetState: BottomSheetState, coroutineScope: CoroutineScope) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
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
                    .align(CenterVertically),
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
                    .align(CenterVertically),
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
                    .align(CenterVertically),
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
        Text(
            modifier = Modifier.padding(start = 20.dp, top = 12.dp, bottom = 8.dp),
            text = "Brand",
            color = MaterialTheme.colors.black200,
            fontSize = 18.sp,
            fontWeight = FontWeight(500)
        )
        BrandSelection()
        Text(
            modifier = Modifier.padding(start = 20.dp, top = 12.dp, bottom = 8.dp),
            text = "Price",
            color = MaterialTheme.colors.black200,
            fontSize = 18.sp,
            fontWeight = FontWeight(500)
        )
        PriceSelection()
        Text(
            modifier = Modifier.padding(start = 20.dp, top = 12.dp, bottom = 8.dp),
            text = "Size",
            color = MaterialTheme.colors.black200,
            fontSize = 18.sp,
            fontWeight = FontWeight(500)
        )
        SizeSelection()
    }
}

@Composable
fun DropDownList(
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
                Text(it, modifier = Modifier
                    .wrapContentWidth())
            }
        }
    }
}

@Composable
fun BrandSelection() {
    val countryList = listOf(
        "Apple",
        "Samsung",
        "Xiaomi",
        "Motorola",
    )
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
                    .border(width = 2.dp,
                            color = MaterialTheme.colors.grey,
                            shape = RoundedCornerShape(5.dp)),
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
                list = countryList,
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
fun PriceSelection() {
    val countryList = listOf(
        "$300 - $500",
        "$500 - $800",
        "$800 - 1200",
        "$1200 - 1500",
    )
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
                    .border(width = 2.dp,
                            color = MaterialTheme.colors.grey,
                            shape = RoundedCornerShape(5.dp)),
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
                list = countryList,
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
fun SizeSelection() {
    val countryList = listOf(
        "4.5 to 5.5 inches",
        "5.5 to 6.5 inches",
        "6.5 to 7.5 inches",
        "7.5 to 8.5 inches",
    )
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
                    .border(width = 2.dp,
                            color = MaterialTheme.colors.grey,
                            shape = RoundedCornerShape(5.dp)),
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
                list = countryList,
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
