package com.codewithmandyal.shoppingcartsystemdesign.domain.repository

import com.codewithmandyal.shoppingcartsystemdesign.domain.models.cart.CartData

interface CartRepository {
    suspend fun getCart(id: Int): CartData
}