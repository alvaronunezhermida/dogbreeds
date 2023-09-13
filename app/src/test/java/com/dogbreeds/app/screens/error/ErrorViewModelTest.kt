package com.dogbreeds.app.screens.error

import app.cash.turbine.test
import arrow.core.right
import com.dogbreeds.app.navigation.AppNavigator
import com.dogbreeds.app.testcommons.CoroutinesTestRule
import com.dogbreeds.app.testcommons.sampleBreed
import com.dogbreeds.domain.Empty
import com.dogbreeds.usecases.GetAllBreedsUseCase
import com.dogbreeds.usecases.LoadAllBreedsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ErrorViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Mock
    lateinit var appNavigator: AppNavigator

    private lateinit var vm: ErrorViewModel

    @Before
    fun setUp() {
        vm = ErrorViewModel(appNavigator)
    }

    @Test
    fun `Navigates back when okButtonClicked is called`() = runTest {
        vm.onOkButtonClicked()
        verify(appNavigator).goBack()
    }
}
