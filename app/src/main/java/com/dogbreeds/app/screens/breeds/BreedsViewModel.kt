package com.dogbreeds.app.screens.breeds

import com.dogbreeds.app.navigation.AppNavigator
import com.dogbreeds.app.screens.AppViewModel
import com.dogbreeds.usecases.GetAllBreedsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BreedsViewModel(
    private val getAllBreedsUseCase: GetAllBreedsUseCase,
    appNavigator: AppNavigator
) : AppViewModel(appNavigator = appNavigator) {

    private val breedsMutableState = MutableStateFlow(emptyList<String>())
    val breedsState: StateFlow<List<String>>
        get() = breedsMutableState

    override fun onStarted() {
        super.onStarted()
        launchGetVertebras()
    }

    private fun launchGetVertebras() {
        launch {
            getAllBreedsUseCase().collect { either ->
                either.fold(
                    ifLeft = { error ->
                        appNavigator.toError(error)
                    },
                    ifRight = { breeds ->
                        breedsMutableState.value = breeds
                    }
                )

            }
        }
    }


    fun onBreedClicked(breed: String) {
        //TODO: Navigate to breed detail
    }

}