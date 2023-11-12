package com.example

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.UpComingShow
import com.example.sea.R

class UpComingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var name: TextView = itemView.findViewById(R.id.upComingTitle)
    private var time: TextView = itemView.findViewById(R.id.upComingTime)
    private var image: ImageView = itemView.findViewById(R.id.upComingImg)

    @SuppressLint("ClickableViewAccessibility")
    fun bind(data: UpComingShow, onClick: (View) -> Unit) {
        name.text = data.title
        time.text = data.time
        image.setImageResource(data.image)
        itemView.setOnClickListener{
            onClick(it)
        }
    }

    companion object {
        fun create(parent: ViewGroup): UpComingItemViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.upcoming_show, parent, false)
            return UpComingItemViewHolder(view)
        }
    }
}