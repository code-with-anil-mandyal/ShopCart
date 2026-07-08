package com.codewithmandyal.shoppingcartsystemdesign.data.mapper

import com.codewithmandyal.shoppingcartsystemdesign.data.dto.cartDto.CartResponseDto
import com.codewithmandyal.shoppingcartsystemdesign.domain.models.cart.CartData

fun CartResponseDto.toDomain() : CartData {
    return CartData(
        discountedTotal = discountedTotal,
        id = id,
        products = productDtos?.map { it.toDomain() }!!,
        total = total,
        totalProducts = totalProducts,
        totalQuantity = totalQuantity,
        userId = userId
    )
}