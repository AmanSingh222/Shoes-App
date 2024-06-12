package com.example.shoesapp.Screens

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailScreen(productId: String = "1") {

    val product = GetProductList().find {
        it.id == productId

    }!!

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


    val selectedColor by remember {
        mutableStateOf(product.shoeColor)
    }


    var productScale by remember {
        mutableStateOf(0.6f)
    }
    var productRotate by remember {
        mutableStateOf(-60f)
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
            onClick = {},
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
        Column(

        ) {
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
                        style = androidx.compose.ui.text.TextStyle(
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
                            style = androidx.compose.ui.text.TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            ),
                            fontWeight = FontWeight.Bold
                        )
                    }


                }
                Text(
                    text = "Rs. ${product.price.toString()}",
                    modifier = Modifier.padding(top = 4.dp),
                    fontSize = 36.sp,
                    color = Color.Black,

                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )
            }




            Text(
                text = "Size",
                modifier = Modifier.padding(horizontal = 22.dp),
                fontSize = 10.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

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
        Color.Black
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
            .border(width = border, color = backGroundColor, shape = RoundedCornerShape(12.dp))
            .background(backGroundColor)
            .clickable { onClick }
            .padding(12.dp), fontSize = 12.sp, color = textColor

    )

}