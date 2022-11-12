package com.firdavs.common.di

import com.firdavs.common.FeatureEntry
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class FeatureEntryKey(val value: KClass<out FeatureEntry>)