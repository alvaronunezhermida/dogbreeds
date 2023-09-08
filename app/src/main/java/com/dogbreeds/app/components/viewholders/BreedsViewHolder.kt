package com.dogbreeds.app.components.viewholders

import com.dogbreeds.app.databinding.ViewHolderBreedsBinding

class BreedsViewHolder(
    private val onBreedClicked: (String) -> Unit,
    binding: ViewHolderBreedsBinding
) : BaseViewHolder<String, ViewHolderBreedsBinding>(binding = binding) {

    override fun bind(item: String) {
        binding.breedNameText.text = item
    }

}