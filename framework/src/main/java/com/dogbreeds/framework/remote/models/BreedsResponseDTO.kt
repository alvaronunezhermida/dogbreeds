package com.dogbreeds.framework.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class BreedsResponseDTO(
    @field:Json(name = "message") val message: List<String>? = null,
    @field:Json(name = "status") val status: String? = null
)