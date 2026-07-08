package com.codewithmandyal.shoppingcartsystemdesign.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codewithmandyal.shoppingcartsystemdesign.presentation.screens.cart.CartScreen
import com.codewithmandyal.shoppingcartsystemdesign.presentation.screens.splash.SplashScreen

@Composable
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.SPLASH_SCREEN.route,
        modifier = modifier
    ) {
        composable(route = ScreenRoutes.SPLASH_SCREEN.route) {
            SplashScreen(
                navigateToHome = {
                    navController.navigate(ScreenRoutes.CART_SCREEN.route) {
                        popUpTo(ScreenRoutes.SPLASH_SCREEN.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = ScreenRoutes.CART_SCREEN.route) {
            CartScreen()
        }
    }
}