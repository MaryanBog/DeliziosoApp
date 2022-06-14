package com.myproj.delizioso

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.myproj.delizioso.screen.ApplicationScreen
import com.myproj.delizioso.ui.theme.AppTheme
import com.myproj.delizioso.ui.theme.DeliziosoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliziosoTheme {
                val systemUiController = rememberSystemUiController()
                val primaryBackgroundColor = AppTheme.color.primaryBackground

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = primaryBackgroundColor,
                        darkIcons = true
                    )
                }
                ApplicationScreen()
            }
        }
    }
}
