package com.myproj.delizioso.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun DeliziosoTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColorProvider provides lightPalette,
        content = content
    )
}

object AppTheme {
    val color: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColorProvider.current
}

val LocalColorProvider = staticCompositionLocalOf<Colors> {
    error("No default color provided")
}