package com.example.shoesapp.Models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class ProductModel(
    var id:String,
    var name:String,
    var shoeColor:Color,
    var price :Float,
    var discountPrice:Float,
    var Size: Int,
    var rating: Float,
     @DrawableRes var imageRes:Int

)
