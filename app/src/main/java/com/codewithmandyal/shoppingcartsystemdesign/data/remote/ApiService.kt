package com.codewithmandyal.shoppingcartsystemdesign.data.remote

import com.codewithmandyal.shoppingcartsystemdesign.data.dto.cartDto.CartResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("carts/{id}")
    suspend fun getCart(
        @Path("id") id: Int
    ): CartResponseDto
}