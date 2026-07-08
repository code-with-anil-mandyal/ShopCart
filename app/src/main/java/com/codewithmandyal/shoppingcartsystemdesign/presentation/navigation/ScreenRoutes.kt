package com.codewithmandyal.shoppingcartsystemdesign.presentation.navigation

sealed class ScreenRoutes(val route: String) {
    object SPLASH_SCREEN : ScreenRoutes("splash_screen")
    object CART_SCREEN : ScreenRoutes("cart_screen")
}