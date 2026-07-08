package com.codewithmandyal.shoppingcartsystemdesign.data.repository

import com.codewithmandyal.shoppingcartsystemdesign.data.mapper.toDomain
import com.codewithmandyal.shoppingcartsystemdesign.data.remote.ApiService
import com.codewithmandyal.shoppingcartsystemdesign.domain.models.cart.CartData
import com.codewithmandyal.shoppingcartsystemdesign.domain.repository.CartRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): CartRepository {

    override suspend fun getCart(id: Int): CartData {
        return apiService.getCart(id).toDomain()
    }
}