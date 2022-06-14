package com.myproj.delizioso.screen.splash

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(username: String){
Text(text = "Hello, $username", fontWeight = FontWeight.Medium, fontSize = 26.sp)
}