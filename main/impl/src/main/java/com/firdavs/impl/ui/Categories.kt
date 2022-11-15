package com.firdavs.impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firdavs.common.domain.Category
import com.firdavs.common.domain.CategoryList
import com.firdavs.common.ui.theme.black200
import com.firdavs.common.ui.theme.black25alpha
import com.firdavs.common.ui.theme.grey
import com.firdavs.ecommerce.main.impl.R

@Composable
internal fun Categories(categories: CategoryList, onCategoryClick: (Int) -> Unit) {
    Column(
        modifier = Modifier.padding(top = 18.dp)
    ) {
        Row(
            modifier = Modifier
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
                modifier = Modifier.align(Alignment.CenterVertically),
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
                    onCategoryClick(category.id)
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
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = category.iconId),
                contentDescription = null,
                tint = if (isSelected) Color.White else MaterialTheme.colors.grey
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
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