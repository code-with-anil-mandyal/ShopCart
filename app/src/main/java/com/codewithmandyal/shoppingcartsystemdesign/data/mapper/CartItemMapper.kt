package com.codewithmandyal.shoppingcartsystemdesign.data.mapper

import com.codewithmandyal.shoppingcartsystemdesign.data.dto.cartDto.ProductDto
import com.codewithmandyal.shoppingcartsystemdesign.domain.models.cart.Product

fun ProductDto.toDomain(): Product {
    return Product(
        discountPercentage = discountPercentage,
        discountedTotal = discountedTotal,
        id = id?:0,
        price = price?:0.0,
        quantity = quantity?:0,
        thumbnail = thumbnail?:"",
        title = title?:"",
        total = total?:0.0
    )
}


