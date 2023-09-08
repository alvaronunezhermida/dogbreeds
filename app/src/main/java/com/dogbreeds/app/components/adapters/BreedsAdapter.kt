package com.dogbreeds.app.components.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dogbreeds.app.components.diffs.BreedsDiff
import com.dogbreeds.app.components.viewholders.BreedsViewHolder
import com.dogbreeds.app.databinding.ViewHolderBreedsBinding

class BreedsAdapter(
    private val onBreedClicked: (String) -> Unit,
) : ListAdapter<String, BreedsViewHolder>(BreedsDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedsViewHolder =
        BreedsViewHolder(
            onBreedClicked = onBreedClicked,
            binding = ViewHolderBreedsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: BreedsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}