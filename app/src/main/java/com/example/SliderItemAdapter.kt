package com.example

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.data.UpComingShow

class SliderItemAdapter(diffCallback: DiffUtil.ItemCallback<Int>) : ListAdapter<Int, SliderItemViewHolder>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderItemViewHolder {
        return SliderItemViewHolder.create(parent)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: SliderItemViewHolder, position: Int) {
        val current: Int = getItem(position)
        holder.bind(current)
    }

    class SliderItemDiff : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }
}