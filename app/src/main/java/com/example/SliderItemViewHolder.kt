package com.example

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.example.data.UpComingShow
import com.example.sea.R

class SliderItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var image: ImageView = itemView.findViewById(R.id.sliderImg)

    @SuppressLint("ClickableViewAccessibility")
    fun bind(@DrawableRes data: Int) {
        image.setImageResource(data)
    }

    companion object {
        fun create(parent: ViewGroup): SliderItemViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.slider_item, parent, false)
            return SliderItemViewHolder(view)
        }
    }
}