package com.firdavs.common.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
inline fun <reified VM: ViewModel> injectedViewModel(
    key: String? = null,
    crossinline viewModelInstanceCreator: @DisallowComposableCalls () -> VM
): VM {
    val factory = remember(key) {
        object: ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
                return viewModelInstanceCreator() as VM
            }
        }
    }
    return viewModel(key = key, factory = factory)
}