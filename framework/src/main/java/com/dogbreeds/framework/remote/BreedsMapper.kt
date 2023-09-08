package com.dogbreeds.framework.remote

import com.dogbreeds.framework.remote.models.BreedsResponseDTO

fun BreedsResponseDTO.toDomain() = breeds?.map {
    if (it.value.isEmpty()) it.key
    else it.value.map { subBreed -> "$it.key $subBreed" }.toString()
} ?: emptyList()