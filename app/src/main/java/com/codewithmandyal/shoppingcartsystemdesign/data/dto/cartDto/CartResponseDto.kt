package com.codewithmandyal.shoppingcartsystemdesign.data.dto.cartDto


import com.google.gson.annotations.SerializedName

data class CartResponseDto(
    @SerializedName("discountedTotal")
    val discountedTotal: Double?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("products")
    val productDtos: List<ProductDto>?,
    @SerializedName("total")
    val total: Double?,
    @SerializedName("totalProducts")
    val totalProducts: Int?,
    @SerializedName("totalQuantity")
    val totalQuantity: Int?,
    @SerializedName("userId")
    val userId: Int?
)