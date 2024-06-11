package com.example.shoesapp.Screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun ProductDetailScreen(productId: String = "1") {

    var product = GetProductList().find {
        it.id == productId

    }!!

    var xOffset: Dp by remember {
        mutableStateOf(800.dp)
    }
    var yOffset: Dp by remember {
        mutableStateOf(800.dp)
    }

    var animationXOffset = animateDpAsState(
        targetValue = xOffset, label = "", animationSpec = tween(
            600, easing = FastOutSlowInEasing
        )
    )

    var animationYOffset = animateDpAsState(
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
            modifier = Modifier
                .scale(animationProductState.value)
                .rotate(animationProductRotate.value)
                .padding(48.dp, 30.dp)
        ) {
            Image(painter = painterResource(id = product.imageRes), contentDescription = null)
        }


    }

}