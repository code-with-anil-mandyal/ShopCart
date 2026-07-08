package com.codewithmandyal.shoppingcartsystemdesign.common

fun Double.calculateDiscount(discountPrice: Double?): Double {
    return if (discountPrice != null) {
        this - discountPrice
    } else {
        this
    }
}

fun Double.calculateDiscountPercentage(discountPrice: Double?): Double{
    return if (discountPrice != null) {
        ((this - discountPrice) / this) * 100
    } else {
        0.0
    }
}