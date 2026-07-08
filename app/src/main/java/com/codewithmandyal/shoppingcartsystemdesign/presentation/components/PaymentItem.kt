package com.codewithmandyal.shoppingcartsystemdesign.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewithmandyal.shoppingcartsystemdesign.domain.models.PaymentMethods

@Composable
fun PaymentItem(
    paymentMethods: PaymentMethods,
    isSelected: Boolean,
    onClick: () -> Unit
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{
                onClick()
            }
            .padding(vertical = 5.dp)
            .height(55.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(

        ) {
            Icon(
                imageVector = paymentMethods.imageVector,
                contentDescription = null,
                tint = Color(0xFF2563EB)
            )

            Spacer(Modifier.width(10.dp))

            Text(
                text = paymentMethods.title,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
            )
        }

        Icon(
            imageVector = if(isSelected) Icons.Outlined.CheckCircle else Icons.Outlined.Circle,
            contentDescription = null,
            tint = if(isSelected) Color(0xFF2563EB) else Color.LightGray
        )

    }

}