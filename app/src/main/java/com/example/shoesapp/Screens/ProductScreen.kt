package com.example.shoesapp.Screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.shoesapp.Models.ProductModel
import com.example.shoesapp.R

@Composable
fun ProductScreen() {
    var product= remember {
        GetProductList()
    }


    LazyVerticalGrid(columns = GridCells.Fixed(4),modifier= Modifier.padding(8.dp)){
        items(product){

        }
    }
}



fun GetProductList(): List<ProductModel> {

    return listOf(
        ProductModel(
            id = "1",
            name = "Nike",
            shoeColor = Color.Blue,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.nike_purple
        ),
        ProductModel(
            id = "2",
            name = "Nike red",
            shoeColor = Color.Red,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.nike_red_black
        ),
        ProductModel(
            id = "3",
            name = "Nike Blue",
            shoeColor = Color.Blue,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.nike_purple
        ),
        ProductModel(
            id = "4",
            name = "Nike ",
            shoeColor = Color.Blue,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.nike_red_black
        ),
        ProductModel(
            id = "5",
            name = "Nike",
            shoeColor = Color.Blue,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.nike_purple
        ),
        ProductModel(
            id = "6",
            name = "Nike ",
            shoeColor = Color.Blue,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.nike_red_black
        ),
        ProductModel(
            id = "7",
            name = "Nike",
            shoeColor = Color.Blue,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.nike_purple
        ),
        ProductModel(
            id = "8",
            name = "Nike ",
            shoeColor = Color.Blue,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.nike_red_black
        ),
        ProductModel(
            id = "9",
            name = "Nike",
            shoeColor = Color.Blue,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.nike_purple
        ),
    )

}