package com.dogbreeds.app.screens.error

import com.dogbreeds.app.navigation.ActivityNavigator
import com.dogbreeds.app.screens.BaseViewModel

class ErrorViewModel(private val activityNavigator: ActivityNavigator) : BaseViewModel() {

    fun onOkButtonClicked() {
        activityNavigator.goBack()
    }

}