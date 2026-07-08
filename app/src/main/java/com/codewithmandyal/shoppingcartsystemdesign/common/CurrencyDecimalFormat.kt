package com.codewithmandyal.shoppingcartsystemdesign.common

fun Double.toPrice(): String {
    return String.format("%.2f", this)
}