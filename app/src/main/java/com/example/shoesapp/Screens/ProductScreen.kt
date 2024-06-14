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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.example.shoesapp.Components.ProductItem
import com.example.shoesapp.Models.ProductModel
import com.example.shoesapp.Navigation.NavigationItem
import com.example.shoesapp.R

@Composable
fun ProductScreen(navController: NavController) {
    var products= remember {
        GetProductList()
    }


    LazyVerticalGrid(columns = GridCells.Fixed(2),modifier= Modifier.padding(8.dp)){
        items(products){
            ProductItem(product = it) {
                navController.navigate("NavigationItem.PRODUCT_DETAILS/${it.id}")
            }
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
            imageRes = R.drawable.p1
        ),
        ProductModel(
            id = "2",
            name = "Nike red",
            shoeColor = Color.Red,
            price = 12000f,
            discountPrice = 10000f,
            Size = 9,
            rating = 4.2f,
            imageRes = R.drawable.p2
        ),
        ProductModel(
            id = "3",
            name = "Nike Blue",
            shoeColor = Color.Black,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.p3
        ),
        ProductModel(
            id = "4",
            name = "Nike ",
            shoeColor = Color.White,
            price = 12000f,
            discountPrice = 10000f,
            Size = 7,
            rating = 4.2f,
            imageRes = R.drawable.p4
        ),
        ProductModel(
            id = "5",
            name = "Nike",
            shoeColor = Color.Gray,
            price = 12000f,
            discountPrice = 10000f,
            Size = 9,
            rating = 4.2f,
            imageRes = R.drawable.p5
        ),
        ProductModel(
            id = "6",
            name = "Nike ",
            shoeColor = Color.Gray,
            price = 12000f,
            discountPrice = 10000f,
            Size = 8,
            rating = 4.2f,
            imageRes = R.drawable.p6
        ),
        ProductModel(
            id = "7",
            name = "Nike",
            shoeColor = Color.Yellow,
            price = 12000f,
            discountPrice = 10000f,
            Size = 11,
            rating = 4.2f,
            imageRes = R.drawable.p7
        ),
        ProductModel(
            id = "8",
            name = "Nike ",
            shoeColor = Color.Yellow,
            price = 12000f,
            discountPrice = 10000f,
            Size = 10,
            rating = 4.2f,
            imageRes = R.drawable.p8
        ),
        ProductModel(
            id = "9",
            name = "Nike",
            shoeColor = Color.Black,
            price = 12000f,
            discountPrice = 10000f,
            Size = 9,
            rating = 4.2f,
            imageRes = R.drawable.p9
        ),
    )

}