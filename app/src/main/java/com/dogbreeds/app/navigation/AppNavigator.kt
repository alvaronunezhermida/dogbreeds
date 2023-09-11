package com.dogbreeds.app.navigation

import android.os.Bundle
import com.dogbreeds.app.R
import com.dogbreeds.app.screens.breed_images.BreedImagesConfig.ARG_KEY
import javax.inject.Inject

class AppNavigator @Inject constructor() : ActivityNavigator() {

    fun fromBreedsToBreedImages(breedName: String) {
        goTo(id = R.id.action_breedsFragment_to_breedImagesFragment,
            args = Bundle().apply {
                putString(ARG_KEY, breedName)
            })
    }
}