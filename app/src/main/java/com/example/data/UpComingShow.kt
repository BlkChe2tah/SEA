package com.example.data

import androidx.annotation.DrawableRes
import com.example.sea.R

data class UpComingShow(
    @DrawableRes val image: Int,
    val title: String,
    val time: String
)

val upComingShowItems = listOf(
    UpComingShow(R.drawable.up_coming_show_1, "MIAMI SEA Aquarium", "2:30 PM"),
    UpComingShow(R.drawable.up_coming_show_2, "Manila Ocean Park", "1:30 PM"),
    UpComingShow(R.drawable.up_coming_show_3, "Marine Life Show", "4:30 PM"),
)
