package com.codewithmandyal.shoppingcartsystemdesign.presentation.screens.cart

import com.codewithmandyal.shoppingcartsystemdesign.domain.models.cart.CartData
import com.codewithmandyal.shoppingcartsystemdesign.domain.models.cart.Product

sealed interface CartScreenUiState {

    data object Idle : CartScreenUiState

    data object Loading : CartScreenUiState

    data class Success(
        //val products: List<Product>
        val cartData: CartData
    ) : CartScreenUiState

    data class Error(
        val message: String
    ): CartScreenUiState
}