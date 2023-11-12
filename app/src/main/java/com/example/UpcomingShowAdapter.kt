package com.example

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.data.UpComingShow

class UpcomingShowAdapter(diffCallback: DiffUtil.ItemCallback<UpComingShow>, private val onClick: (View) -> Unit) : ListAdapter<UpComingShow, UpComingItemViewHolder>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingItemViewHolder {
        return UpComingItemViewHolder.create(parent)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: UpComingItemViewHolder, position: Int) {
        val current: UpComingShow = getItem(position)
        holder.bind(current, onClick)
    }

    class UpComingItemDiff : DiffUtil.ItemCallback<UpComingShow>() {
        override fun areItemsTheSame(oldItem: UpComingShow, newItem: UpComingShow): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UpComingShow, newItem: UpComingShow): Boolean {
            return oldItem.title == newItem.title
        }
    }
}