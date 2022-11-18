@file:OptIn(ExperimentalMaterialApi::class)

package com.firdavs.impl.presentation.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.firdavs.common.domain.model.BestSellerEntity
import com.firdavs.common.ui.theme.*
import com.firdavs.impl.presentation.MainViewModel
import com.firdavs.impl.presentation.ui.components.*
import com.firdavs.impl.presentation.ui.components.BestSeller
import com.firdavs.impl.presentation.ui.components.BottomBar
import com.firdavs.impl.presentation.ui.components.Categories
import com.firdavs.impl.presentation.ui.components.FilterOptions
import com.firdavs.impl.presentation.ui.components.HotSales

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onProductClick: (BestSellerEntity) -> Unit,
    onCartClick: () -> Unit
) {
    val categories by viewModel.categories.collectAsState()
    val hotSales by viewModel.hotSales.collectAsState()
    val bestSellers by viewModel.bestSellers.collectAsState()
    val cartProductsCount by viewModel.cartProductsCount.collectAsState()

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
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                TopBar(sheetState, coroutineScope)
                Categories(categories, viewModel::selectCategory)
                SearchBar()
                HotSales(hotSales)
                BestSeller(bestSellers, onProductClick)
            }
            BottomBar(Modifier.align(BottomCenter), onCartClick, cartProductsCount)
        }
    }
}
