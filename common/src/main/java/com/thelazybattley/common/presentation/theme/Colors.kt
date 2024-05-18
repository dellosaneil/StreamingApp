package com.thelazybattley.common.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

val lightColors = Colors(
    white1 = White1,
    black1 = Black1,
    black2 = Black2,
    red1 = Red1
)

data class Colors(
    val white1: Color,
    val red1: Color,
    val black1: Color,
    val black2: Color
)

val LocalColors = compositionLocalOf<Colors> { error("No colors provided") }

val colors: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
