package com.codewithmandyal.shoppingcartsystemdesign.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.codewithmandyal.shoppingcartsystemdesign.common.toPrice
import com.codewithmandyal.shoppingcartsystemdesign.domain.models.cart.Product

@Composable
fun CartItem(product: Product) {

    val itemCount = rememberSaveable { mutableIntStateOf(
        product.quantity
    ) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .background(Color.White,
                shape = RoundedCornerShape(8.dp)
            ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.White),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row() {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(product.thumbnail)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(Modifier.width(15.dp))

                Column(

                ) {

                    Text(
                        text = product.title,
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color(0xFF2563EB),
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(Modifier.height(22.dp))

                    Text(
                        text = "$${product.total?.toPrice()}",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold
                        )
                    )

                    Spacer(Modifier.height(22.dp))

                    Row(
                        modifier = Modifier.border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        ),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        TextButton(
                            onClick = {
                                if(itemCount.intValue > 1){
                                    itemCount.intValue--
                                }

                            }
                        ) {
                            Text(
                                text = "-",
                                style = TextStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 25.sp,
                                    color = Color(0xFF2563EB)
                                )
                            )
                        }

                        Text(
                            text = "${itemCount.value}",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 20.sp,
                                color = Color(0xFF2563EB)
                            ),
                            modifier = Modifier.fillMaxHeight().align(Alignment.CenterVertically),
                        )



                        TextButton(
                            onClick = {
                                itemCount.value++
                            }
                        ) {
                            Text(
                                text = "+",
                                style = TextStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 25.sp,
                                    color = Color(0xFF2563EB)
                                )
                            )
                        }
                    }
                }
            }


            IconButton(
                onClick = {}
            ) {

                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }

    }
}