package com.codewithmandyal.shoppingcartsystemdesign.presentation.screens.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewithmandyal.shoppingcartsystemdesign.domain.useCase.GetCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartScreenViewModel @Inject constructor(
    private val getCartUseCase: GetCartUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<CartScreenUiState>(CartScreenUiState.Loading)
    val uiState : StateFlow<CartScreenUiState> = _uiState


    init {
        getCart()
    }

     fun getCart(){
         viewModelScope.launch {

             _uiState.value = CartScreenUiState.Loading

             try {

                 val randomId = kotlin.random.Random.nextInt(1, 209)

                 val cart = getCartUseCase(randomId)

                 _uiState.value = CartScreenUiState.Success(cart)

             }catch (e: Exception){
                 _uiState.value = CartScreenUiState.Error(
                     e.message?:"Something went wrong"
                 )
             }

         }

    }
}