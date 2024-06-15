package com.example.shoesapp.Screens

import android.widget.Toast
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun ProductDetailScreen(productId: String = "1", navController: NavController) {

    val product = GetProductList().find {
        it.id == productId

    }!!


    val context= LocalContext.current;

    var xOffset: Dp by remember {
        mutableStateOf(800.dp)
    }
    var yOffset: Dp by remember {
        mutableStateOf(800.dp)
    }

    val animationXOffset = animateDpAsState(
        targetValue = xOffset, label = "", animationSpec = tween(
            600, easing = FastOutSlowInEasing
        )
    )

    val animationYOffset = animateDpAsState(
        targetValue = yOffset, label = "", animationSpec = tween(
            600, easing = FastOutSlowInEasing
        )
    )


    var selectedColor by remember {
        mutableStateOf(product.shoeColor)
    }

    var productScale by remember {
        mutableStateOf(0.6f)
    }
    var productRotate by remember {
        mutableStateOf(-20f)
    }
    var selectedSize by remember {
        mutableStateOf(product.Size.toString())
    }

    var isFovorite by remember {
        mutableStateOf(false)
    }

    val animationProductState = animateFloatAsState(targetValue = productScale)
    val animationProductRotate = animateFloatAsState(targetValue = productRotate)

    LaunchedEffect(true) {
        delay(150)
        xOffset = 140.dp
        yOffset = (-130).dp
        productScale = 1f

    }



    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .offset(x = animationXOffset.value, y = animationYOffset.value)
                .alpha(.3f)
                .size(400.dp)
                .background(
                    color = selectedColor,
                    shape = CircleShape
                )

        )

        //this is back button
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .shadow(
                    elevation = 24.dp, spotColor = DefaultShadowColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(color = Color.White, shape = RoundedCornerShape(22.dp))
                .size(36.dp)
        ) {

            Icon(imageVector = Icons.Rounded.KeyboardArrowLeft, contentDescription = null)

        }

        //column for product image
        Column {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .scale(animationProductState.value)
                    .rotate(animationProductRotate.value)
                    .padding(48.dp, 30.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(
                        text = "Sneaker", fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = product.name,
                        fontSize = 22.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 2.dp),
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier
                            .padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            modifier = Modifier.size(18.dp),
                            contentDescription = null,
                            tint = Color(0xFFFFDA45)
                        )
                        Text(
                            text = product.rating.toString(),
                            fontSize = 12.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 2.dp),
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            fontWeight = FontWeight.Bold
                        )
                    }


                }
                Text(
                    text = "Rs. ${product.price}",
                    modifier = Modifier.padding(top = 20.dp),
                    fontSize = 36.sp,
                    color = Color.Black,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontWeight = FontWeight.Bold
                )
            }




            Text(
                text = "Size",
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 10.dp),
                fontSize = 10.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                ProductSizeCard(size = "8", isSelected = selectedSize == "8") {
                    selectedSize = "8"

                }
                ProductSizeCard(size = "9", isSelected = selectedSize == "9") {
                    selectedSize = "9"
                }
                ProductSizeCard(size = "10", isSelected = selectedSize == "10") {
                    selectedSize = "10"

                }
                ProductSizeCard(size = "11", isSelected = selectedSize == "11") {
                    selectedSize = "11"

                }
                ProductSizeCard(size = "12", isSelected = selectedSize == "12") {
                    selectedSize = "12"

                }
            }


            Text(
                text = "Color", modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 24.dp),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 22.dp)
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {


                ProductColor(color = Color.Green, isSelected = selectedColor == Color.Green) {
                    selectedColor = Color.Green

                }

                ProductColor(color = Color.Yellow, isSelected = selectedColor == Color.Yellow) {
                    selectedColor = Color.Yellow

                }
                ProductColor(color = Color.Cyan, isSelected = selectedColor == Color.Cyan) {
                    selectedColor = Color.Cyan

                }

                ProductColor(color = Color.Magenta, isSelected = selectedColor == Color.Magenta) {
                    selectedColor = Color.Magenta

                }

                ProductColor(color = Color.Blue, isSelected = selectedColor == Color.Blue) {
                    selectedColor = Color.Blue
                }
            }


            Text(
                text = "The Nike Air Max, introduced in 1987, is renowned for its visible air cushioning, providing superior comfort and impact protection. Designed by Tinker Hatfield, the original Air Max 1 set a trend with its innovative design. Popular models include the Air Max 90, 95, and 97, each featuring unique design elements and enhanced Air-Sole units. The Air Max line has transcended sports to become a cultural icon, celebrated for its bold aesthetics and numerous collaborations. The shoe is honored annually on Air Max Day, March 26th",
                modifier = Modifier
                    .padding(
                        top = 6.dp,
                    )
                    .padding(horizontal = 22.dp), color = Color.Black,
                fontWeight = FontWeight.Light,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Spacer(modifier = Modifier.weight(1f))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .padding(horizontal = 22.dp)
            ) {


                IconButton(onClick = { isFovorite = !isFovorite }) {
                    Icon(
                        imageVector = if (isFovorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isFovorite) Color.Red else MaterialTheme.colorScheme.onSurface
                    )
                }

                Spacer(modifier = Modifier.width(4.dp))
                //This is cart button
                Button(
                    onClick = { Toast.makeText(context,"Added",Toast.LENGTH_SHORT).show() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(start = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue
                    )
                ) {
                    Icon(imageVector = Icons.Rounded.ShoppingCart, contentDescription = null)
                    Text(text = "Add to Cart")

                }


            }


        }

    }

}


@Composable
fun ProductSizeCard(
    modifier: Modifier = Modifier,
    size: String,
    isSelected: Boolean,
    onClick: () -> Unit

) {
    val backGroundColor = if (isSelected) {
        Color.Red
    } else {
        Color.White
    }

    var textColor = if (isSelected) {
        Color.White
    } else {
        Color.Black
    }

    var border = if (isSelected) 0.dp else 0.8.dp

    Text(
        text = size, modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(width = border, color = Color.Black, shape = RoundedCornerShape(12.dp))
            .background(backGroundColor)
            .clickable { onClick() }
            .padding(12.dp), fontSize = 12.sp, color = textColor

    )

}


//Color selected
@Composable
fun ProductColor(
    modifier: Modifier = Modifier,
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val BorderColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent

    Box(
        modifier = Modifier
            .border(width = 0.5.dp, color = BorderColor, shape = CircleShape)
            .padding(4.dp)
            .clip(CircleShape)
            .background(color, shape = CircleShape)
            .size(24.dp)
            .clickable { onClick() }
    )


}
