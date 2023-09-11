package com.dogbreeds.app.components.diffs

import androidx.recyclerview.widget.DiffUtil
import com.dogbreeds.domain.Breed

class BreedsDiff : DiffUtil.ItemCallback<Breed>() {

    override fun areItemsTheSame(oldItem: Breed, newItem: Breed): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Breed, newItem: Breed): Boolean =
        oldItem.breedName == newItem.breedName

}