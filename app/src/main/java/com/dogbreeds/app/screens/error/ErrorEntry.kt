package com.dogbreeds.app.screens.error

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


sealed class ErrorEntry : Parcelable {
    @Parcelize
    data class Custom(
        val title: String,
        val detail: String
    ) : ErrorEntry()

    @Parcelize
    data object NullParams : ErrorEntry()

    @Parcelize
    data object Unknown : ErrorEntry()
}