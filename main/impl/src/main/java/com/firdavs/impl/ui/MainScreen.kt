@file:OptIn(ExperimentalMaterialApi::class)

package com.firdavs.impl.ui

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
import com.firdavs.impl.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel, onProductClick: (BestSellerEntity) -> Unit) {
    val categories by viewModel.categories.collectAsState()
    val hotSales by viewModel.hotSales.collectAsState()
    val bestSellers by viewModel.bestSellers.collectAsState()

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
            BottomBar(Modifier.align(BottomCenter))
        }
    }
}
