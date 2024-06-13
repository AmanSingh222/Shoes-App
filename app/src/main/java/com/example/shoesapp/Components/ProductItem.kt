package com.example.shoesapp.Components

import android.graphics.Paint.Style
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoesapp.Models.ProductModel
import com.example.shoesapp.R

@Preview(showBackground = true)
@Composable
fun ProductItem(
    product: ProductModel = ProductModel(
        id = "1",
        name = "Nike",
        shoeColor = colorResource(id = R.color.grey2),
        price = 12000f,
        discountPrice = 10000f,
        Size = 11,
        rating = 4.2f,
        imageRes = R.drawable.p1
    )
) {

    var color by remember {
        mutableStateOf(product.shoeColor)
    }
    var isFavorite by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .padding(20.dp)
            .size(168.dp, 210.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(.2f)
                .background(color = color, shape = RoundedCornerShape(22.dp))
        )

        IconButton(onClick = {
            isFavorite = !isFavorite

        }, modifier = Modifier.align(Alignment.TopStart)) {

            Icon(
                imageVector =
                if (isFavorite)
                    Icons.Rounded.Favorite
                else
                    Icons.Rounded.FavoriteBorder, contentDescription = null
            )
        }

        Text(
            text = product.Size.toString(),
            fontWeight = FontWeight.Bold,
            color = color.copy(.3f),
            fontSize = 120.sp,
            modifier = Modifier.align(Alignment.TopCenter)
        )

        Image(
            painter = painterResource(id = product.imageRes), contentDescription = null,
            modifier = Modifier
                .fillMaxSize(1f)
                .align(Alignment.Center)
                .rotate(-30f)
                .offset(40.dp, (-20).dp)
                .size(100.dp)
        )
        Column(
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text(text = "Rs. ${product.discountPrice}",
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                modifier= Modifier.padding(end = 8.dp))

            Text(text = "Rs. ${product.price}",
                fontWeight = FontWeight.Bold,
                fontSize = 8.sp,
                modifier= Modifier.padding(end = 8.dp, bottom = 8.dp).align(Alignment.End),
                style = TextStyle(
                    textDecoration = TextDecoration.LineThrough
                )

            )

        }


    }
}