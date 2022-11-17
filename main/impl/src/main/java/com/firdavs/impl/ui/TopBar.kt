@file:OptIn(ExperimentalMaterialApi::class)

package com.firdavs.impl.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firdavs.common.ui.theme.black200
import com.firdavs.common.ui.theme.black25alpha
import com.firdavs.common.ui.theme.grey
import com.firdavs.ecommerce.main.impl.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun TopBar(sheetState: BottomSheetState, coroutineScope: CoroutineScope) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 11.dp)
                    .align(Alignment.CenterVertically),
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
                modifier = Modifier.align(Alignment.CenterVertically),
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