package com.dogbreeds.app.components.viewholders

import com.dogbreeds.app.databinding.ViewHolderBreedsBinding
import com.dogbreeds.domain.Breed

class BreedViewHolder(
    private val onBreedClicked: (Breed) -> Unit,
    binding: ViewHolderBreedsBinding
) : BaseViewHolder<Breed, ViewHolderBreedsBinding>(binding = binding) {

    override fun bind(item: Breed) {
        binding.root.setOnClickListener { onBreedClicked(item) }

        val breedName = item.breedName.split(" ")
            .joinToString(" ") { it.replaceFirstChar { firstChar -> firstChar.uppercase() } }
        binding.breedNameText.text = breedName
    }

}