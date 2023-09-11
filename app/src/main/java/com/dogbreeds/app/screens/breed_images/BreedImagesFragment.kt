package com.dogbreeds.app.screens.breed_images

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.dogbreeds.app.R
import com.dogbreeds.app.components.adapters.BreedImagesAdapter
import com.dogbreeds.app.databinding.FragmentBreedsBinding
import com.dogbreeds.app.screens.BaseFragment
import com.dogbreeds.domain.BreedImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedImagesFragment : BaseFragment<FragmentBreedsBinding, BreedImagesViewModel>() {

    override val viewModel: BreedImagesViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    private lateinit var breedImagesAdapter: BreedImagesAdapter

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBreedsBinding = FragmentBreedsBinding.inflate(inflater, container, false)

    override fun initViews() {
        super.initViews()
        initBreedImagesList()
    }

    override fun initObservers() {
        super.initObservers()
        launchWhenStarted { viewModel.breedImagesState.collect(::observeBreeds) }
    }

    private fun initBreedImagesList() {
        binding.breedsRecycler.setHasFixedSize(true)
        breedImagesAdapter = BreedImagesAdapter()
        binding.breedsRecycler.adapter = breedImagesAdapter
    }

    private fun observeBreeds(breedImages: List<BreedImage>) {
        breedImagesAdapter.submitList(breedImages)
        binding.emptyState.root.isVisible = breedImages.isEmpty()
        binding.breedsRecycler.isVisible = breedImages.isNotEmpty()
    }
}