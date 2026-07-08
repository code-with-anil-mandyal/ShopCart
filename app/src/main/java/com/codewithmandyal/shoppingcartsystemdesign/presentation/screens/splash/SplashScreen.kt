package com.codewithmandyal.shoppingcartsystemdesign.presentation.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigateToHome: ()  -> Unit) {

    LaunchedEffect(Unit) {
        delay(3000)
        navigateToHome()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2563EB)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Filled.ShoppingBag,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(100.dp)
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "Vivid Commerce",
            style = TextStyle(
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(Modifier.height(5.dp))

        Text(
            text = "HYPER-VELOCITY SHOPPING",
            style = TextStyle(
                color = Color.LightGray,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        )

    }
}