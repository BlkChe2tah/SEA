package com.example.data

import androidx.annotation.DrawableRes
import com.example.sea.R

data class GridData(
    @DrawableRes val icon: Int,
    val label: String
)

val gridItems = arrayListOf(
    GridData(R.drawable.map, "Map"),
    GridData(R.drawable.fish, "Inhabitants"),
    GridData(R.drawable.letter, "Shows"),
    GridData(R.drawable.shopping, "Shopping"),
    GridData(R.drawable.resturant, "Dine"),
    GridData(R.drawable.chat, "Meet & Greets"),
)