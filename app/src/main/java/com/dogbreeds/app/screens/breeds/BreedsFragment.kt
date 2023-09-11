package com.dogbreeds.app.screens.breeds

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.dogbreeds.app.R
import com.dogbreeds.app.components.adapters.BreedsAdapter
import com.dogbreeds.app.databinding.FragmentBreedsBinding
import com.dogbreeds.app.screens.BaseFragment
import com.dogbreeds.domain.Breed
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedsFragment : BaseFragment<FragmentBreedsBinding, BreedsViewModel>() {

    override val viewModel: BreedsViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    private lateinit var breedsAdapter: BreedsAdapter

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBreedsBinding = FragmentBreedsBinding.inflate(inflater, container, false)

    override fun initViews() {
        super.initViews()
        initBreedsList()
    }

    override fun initObservers() {
        super.initObservers()
        launchWhenStarted { viewModel.breedsState.collect(::observeBreeds) }
    }

    private fun initBreedsList() {
        binding.breedsRecycler.setHasFixedSize(true)
        breedsAdapter =
            BreedsAdapter(onBreedClicked = viewModel::onBreedClicked)
        binding.breedsRecycler.adapter = breedsAdapter
    }

    private fun observeBreeds(breeds: List<Breed>) {
        breedsAdapter.submitList(breeds)
        binding.emptyState.root.isVisible = breeds.isEmpty()
        binding.breedsRecycler.isVisible = breeds.isNotEmpty()
    }

}