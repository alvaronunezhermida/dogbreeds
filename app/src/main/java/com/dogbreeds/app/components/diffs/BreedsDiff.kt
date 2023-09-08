package com.dogbreeds.app.components.diffs

import androidx.recyclerview.widget.DiffUtil

class BreedsDiff : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

}