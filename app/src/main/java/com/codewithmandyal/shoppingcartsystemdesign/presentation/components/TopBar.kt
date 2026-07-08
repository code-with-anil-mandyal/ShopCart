package com.codewithmandyal.shoppingcartsystemdesign.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .size(55.dp)
    ) {

//        IconButton(
//            onClick = {},
//            modifier = Modifier.align(Alignment.CenterStart)
//        ) {
//            Icon(
//                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                contentDescription = "back",
//                tint = Color(0xFF2563EB)
//            )
//        }

        Text(
            text = "Shopping Cart",
            style = TextStyle(
                color = Color(0xFF2563EB),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            ),
            modifier = Modifier.align(Alignment.Center)
        )

    }
}