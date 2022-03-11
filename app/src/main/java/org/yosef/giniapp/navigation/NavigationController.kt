package org.yosef.giniapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.yosef.giniapp.screens.numbers.NumbersScreen
import org.yosef.giniapp.screens.splash.SplashScreen

@Composable
fun NavigationController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreensViews.SplashScreen.name
    ) {
        composable(ScreensViews.SplashScreen.name) {
            SplashScreen(navController = navController)
        }

        composable(ScreensViews.NumbersScreen.name) {
            NumbersScreen(navController = navController)
        }
    }
}