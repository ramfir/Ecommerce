package com.firdavs.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firdavs.common.domain.model.BestSellerEntity
import com.firdavs.common.domain.model.Category
import com.firdavs.common.domain.model.CategoryList
import com.firdavs.common.domain.model.HotSaleEntity
import com.firdavs.ecommerce.main.impl.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainViewModel @Inject constructor(
    getProducts: GetProducts
): ViewModel() {

    init {
        getProducts()
            .onEach {
                _hotSales.value = it.hotSales
                _bestSellers.value = it.bestSellers
            }
            .launchIn(viewModelScope)
    }

    val _categories = MutableStateFlow(
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
    val categories: StateFlow<CategoryList> = _categories

    val _hotSales = MutableStateFlow<List<HotSaleEntity>>(emptyList())
    val hotSales: StateFlow<List<HotSaleEntity>> = _hotSales

    val _bestSellers = MutableStateFlow<List<BestSellerEntity>>(emptyList())
    val bestSellers: StateFlow<List<BestSellerEntity>> = _bestSellers

    fun selectCategory(id: Int) {
        _categories.value = _categories.value.copy(selectedId = id)
    }
}