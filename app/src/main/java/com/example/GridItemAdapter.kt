package com.example

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.data.GridData
import com.example.data.UpComingShow

class GridItemAdapter(diffCallback: DiffUtil.ItemCallback<GridData>) : ListAdapter<GridData, GridItemViewHolder>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridItemViewHolder {
        return GridItemViewHolder.create(parent)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: GridItemViewHolder, position: Int) {
        val current: GridData = getItem(position)
        holder.bind(current)
    }

    class GridDataDiff : DiffUtil.ItemCallback<GridData>() {
        override fun areItemsTheSame(oldItem: GridData, newItem: GridData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: GridData, newItem: GridData): Boolean {
            return oldItem.label == newItem.label
        }
    }
}