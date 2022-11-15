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
                hotSales.value = it.hotSales
                bestSellers.value = it.bestSellers
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

    /*val _hotSales = MutableStateFlow(
        listOf(
            HotSaleEntity(
                1,
                true,
                "Iphone 12",
                "Súper. Mega. Rápido.",
                "https://img.ibxk.com.br/2020/09/23/23104013057475.jpg?w=1120&h=420&mode=crop&scale=both",
                true
            ),
            HotSaleEntity(
                2,
                false,
                "Samsung Galaxy A71",
                "Súper. Mega. Rápido.",
                "https://cdn-2.tstatic.net/kupang/foto/bank/images/pre-order-samsung-galaxy-a71-laris-manis-inilah-rekomendasi-ponsel-harga-rp-6-jutaan.jpg",
                true
            ),
            HotSaleEntity(
                3,
                true,
                "Xiaomi Mi 11 ultra",
                "Súper. Mega. Rápido.",
                "https://static.digit.in/default/942998b8b4d3554a6259aeb1a0124384dbe0d4d5.jpeg",
                true
            ),
        )
    )
    val hotSales: StateFlow<List<HotSaleEntity>> = _hotSales*/
    val hotSales = MutableStateFlow<List<HotSaleEntity>>(emptyList())

    /*val _bestSellers = MutableStateFlow(
        listOf(
            BestSellerEntity(
                1,
                true,
                "Samsung Galaxy s20 Ultra",
                1500.toDouble(),
                1047.33,
                "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
            ),
            BestSellerEntity(
                2,
                false,
                "Xiaomi Mi 10 Pro",
                1500.toDouble(),
                300.toDouble(),
                "https://mi92.ru/wp-content/uploads/2020/03/smartfon-xiaomi-mi-10-pro-12-256gb-global-version-starry-blue-sinij-1.jpg"
            ),
            BestSellerEntity(
                3,
                false,
                "Samsung Note 20 Ultra",
                1500.toDouble(),
                1047.50,
                "https://opt-1739925.ssl.1c-bitrix-cdn.ru/upload/iblock/c01/c014d088c28d45b606ed8c58e5817172.jpg?160405904823488"
            ),
            BestSellerEntity(
                4,
                true,
                "Motorola One Edge",
                1500.toDouble(),
                1047.toDouble(),
                "https://www.benchmark.rs/assets/img/news/edge1.jpg"
            ),
            BestSellerEntity(
                5,
                true,
                "Samsung Galaxy s20 Ultra",
                1500.toDouble(),
                1047.toDouble(),
                "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
            ),
            BestSellerEntity(
                6,
                false,
                "Xiaomi Mi 10 Pro",
                1500.toDouble(),
                300.toDouble(),
                "https://mi92.ru/wp-content/uploads/2020/03/smartfon-xiaomi-mi-10-pro-12-256gb-global-version-starry-blue-sinij-1.jpg"
            ),
            BestSellerEntity(
                7,
                false,
                "Samsung Note 20 Ultra",
                1500.toDouble(),
                1047.toDouble(),
                "https://opt-1739925.ssl.1c-bitrix-cdn.ru/upload/iblock/c01/c014d088c28d45b606ed8c58e5817172.jpg?160405904823488"
            ),
        )
    )
    val bestSellers: StateFlow<List<BestSellerEntity>> = _bestSellers*/
    val bestSellers = MutableStateFlow<List<BestSellerEntity>>(emptyList())

    fun selectCategory(id: Int) {
        _categories.value = _categories.value.copy(selectedId = id)
    }
}