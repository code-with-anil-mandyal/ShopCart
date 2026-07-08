package com.codewithmandyal.shoppingcartsystemdesign.domain.models.cart

data class CartData(
    val discountedTotal: Double?,
    val id: Int?,
    val products: List<Product>,
    val total: Double?,
    val totalProducts: Int?,
    val totalQuantity: Int?,
    val userId: Int?
)
