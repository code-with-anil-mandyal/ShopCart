package com.codewithmandyal.shoppingcartsystemdesign.presentation.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.codewithmandyal.shoppingcartsystemdesign.common.calculateDiscount
import com.codewithmandyal.shoppingcartsystemdesign.common.calculateDiscountPercentage
import com.codewithmandyal.shoppingcartsystemdesign.common.paymentMethods
import com.codewithmandyal.shoppingcartsystemdesign.common.toPrice
import com.codewithmandyal.shoppingcartsystemdesign.domain.models.cart.CartData
import com.codewithmandyal.shoppingcartsystemdesign.domain.models.cart.Product
import com.codewithmandyal.shoppingcartsystemdesign.presentation.components.CartItem
import com.codewithmandyal.shoppingcartsystemdesign.presentation.components.ErrorView
import com.codewithmandyal.shoppingcartsystemdesign.presentation.components.LoaderView
import com.codewithmandyal.shoppingcartsystemdesign.presentation.components.OrderSummaryItem
import com.codewithmandyal.shoppingcartsystemdesign.presentation.components.PaymentItem
import com.codewithmandyal.shoppingcartsystemdesign.presentation.components.TopBar

@Composable
fun CartScreen(
    cartScreenViewModel: CartScreenViewModel = hiltViewModel()
) {


    val uiState by cartScreenViewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TopBar()

        when(uiState){

            is CartScreenUiState.Idle ->{
                //Idle
                LoaderView()
            }

            is CartScreenUiState.Loading ->{
                LoaderView()
            }

            is  CartScreenUiState.Success ->{
                val cartData = (uiState as CartScreenUiState.Success).cartData
                CartScreenView(cartData)
            }

            is CartScreenUiState.Error ->{
                val message = (uiState as CartScreenUiState.Error).message
                ErrorView(message)
            }
        }

    }




}

@Composable
fun CartScreenView(cartData: CartData) {
    var selectedPaymentId by rememberSaveable {
        mutableIntStateOf(0)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {



        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 180.dp
            )
        ) {





            item {

                Spacer(Modifier.height(10.dp))

            }


            items(cartData.products){
                CartItem(it)
            }

            item {
                Spacer(Modifier.height(20.dp))
            }


            item {
                Text(
                    text = "Payment Methods",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                )
            }

            item {

                Spacer(Modifier.height(15.dp))

            }

            items(paymentMethods) { item ->
                PaymentItem(
                    item,
                    isSelected = item.id == selectedPaymentId,
                    onClick = {
                        selectedPaymentId = item.id
                    })
            }

            item {
                Spacer(Modifier.height(20.dp))
            }

            item {
                OrderSummaryView(cartData)
            }

            item {
                Spacer(Modifier.height(20.dp))
            }

            item {
                ApplyCoupon()
            }



        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth()
                    .height(1.dp)
                    .background(Color.LightGray)
            )


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Column() {
                        Text(
                            text = "FINAL TOTAL",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color.LightGray
                            )
                        )

                        Text(
                            text = "$${cartData.discountedTotal?.toPrice()}",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color(0xFF2563EB)
                            )
                        )
                    }

                    Row{
                        Icon(
                            imageVector = Icons.Filled.FlashOn,
                            contentDescription = null,
                            tint = Color(0xFF7B3F00),
                            modifier = Modifier.size(20.dp)
                        )

                        Text(
                            text = "FAST SHIPPING",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF7B3F00)
                            )
                        )
                    }
                }

                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .background(
                            Color(0xFF2563EB),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Continue",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    )

                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

        }





    }
}

@Composable
fun ApplyCoupon() {
    val coupon = rememberSaveable { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        OutlinedTextField(
            value = coupon.value,
            placeholder = {
                Text(
                    text = "Promo Code",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.LightGray
                    )
                )
            },
            onValueChange = {},
            modifier = Modifier
                .weight(0.65f)
                .height(55.dp)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                )

        )

        Spacer(Modifier.weight(0.05f))

        Button(
            onClick = {},
            modifier = Modifier
                .height(55.dp)
                .weight(0.3f),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF28C28),
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "Apply",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black)
                )
        }

    }
}

@Composable
fun OrderSummaryView(cartData: CartData) {

    val actualPrice = rememberSaveable {
        mutableStateOf(cartData.total)
    }

    val discount = rememberSaveable {
        mutableStateOf(cartData.total?.calculateDiscount(cartData.discountedTotal))
    }

    val discountPercentage = rememberSaveable {
        mutableStateOf(cartData.total?.calculateDiscountPercentage(cartData.discountedTotal))
    }

    Column(
        Modifier
            .fillMaxWidth()
            .border(
                1.dp,
                Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                Color(0xFFEEF2FC),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {

        Text(
            text = "Order Summary",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
        )

        Spacer(Modifier.height(10.dp))



        //Actual Price
        OrderSummaryItem("Subtotal", actualPrice.value?:0.0)


        //Discount
        OrderSummaryItem("Discount(${discountPercentage.value?.toPrice()}%)", discount.value?:0.0)



        //OrderSummaryItem()



        HorizontalDivider(
            modifier = Modifier
                .height(1.dp)
                .padding(vertical = 5.dp)
                .background(Color.LightGray)
        )

        Spacer(Modifier.height(10.dp))

        OrderSummaryItem("Total", cartData.discountedTotal?:0.0)


        }

    }















