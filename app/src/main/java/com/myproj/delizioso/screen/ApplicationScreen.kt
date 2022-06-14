package com.myproj.delizioso.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myproj.delizioso.navigation.NavigationTree
import com.myproj.delizioso.screen.login.LoginScreen
import com.myproj.delizioso.screen.login.LoginViewModel
import com.myproj.delizioso.screen.splash.SplashScreen

@Composable
fun ApplicationScreen(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationTree.Splash.name) {
        composable(NavigationTree.Splash.name) { SplashScreen(navController) }
        composable(NavigationTree.Login.name) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(loginViewModel = loginViewModel) }
    }
}