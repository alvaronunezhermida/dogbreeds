package com.dogbreeds.app.components.viewholders

import com.dogbreeds.app.databinding.ViewHolderBreedsBinding

class BreedsViewHolder(
    private val onBreedClicked: (String) -> Unit,
    binding: ViewHolderBreedsBinding
) : BaseViewHolder<String, ViewHolderBreedsBinding>(binding = binding) {

    override fun bind(item: String) {
        binding.root.setOnClickListener { onBreedClicked(item) }

        val breedName = item.split(" ").joinToString(" ") { it.replaceFirstChar { firstChar -> firstChar.uppercase() } }
        binding.breedNameText.text = breedName
    }

}