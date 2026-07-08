package com.codewithmandyal.shoppingcartsystemdesign.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Money
import androidx.compose.material.icons.outlined.Wallet
import com.codewithmandyal.shoppingcartsystemdesign.domain.models.PaymentMethods

val paymentMethods = listOf(
    PaymentMethods(
        imageVector = Icons.Outlined.Wallet,
        title = "UPI",
        id = 0
    ),
    PaymentMethods(
        imageVector = Icons.Outlined.CreditCard,
        title = "Credit / Debit Card",
        id = 1
    ),
    PaymentMethods(
        imageVector = Icons.Outlined.Money,
        title = "Cash on Delivery",
        id = 2
    )
)