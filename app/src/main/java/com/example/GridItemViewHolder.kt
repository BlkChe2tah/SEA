package com.example

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.example.data.GridData
import com.example.data.UpComingShow
import com.example.sea.R

class GridItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var image: ImageView = itemView.findViewById(R.id.gridItemImage)
    private var textView: TextView = itemView.findViewById(R.id.gridItemText)

    @SuppressLint("ClickableViewAccessibility")
    fun bind(data: GridData) {
        image.setImageResource(data.icon)
        textView.text = data.label
    }

    companion object {
        fun create(parent: ViewGroup): GridItemViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_item, parent, false)
            return GridItemViewHolder(view)
        }
    }
}