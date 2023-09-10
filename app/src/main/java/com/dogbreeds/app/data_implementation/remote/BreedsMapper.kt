package com.dogbreeds.app.data_implementation.remote

import com.dogbreeds.app.data_implementation.remote.models.BreedsResponseDTO

fun BreedsResponseDTO.toDomain(): List<String> {
    val newList = mutableListOf<String>()
    breeds?.map { breed ->
        if (breed.value.isEmpty()) {
            newList.add(breed.key)
        } else {
            breed.value.map {
                newList.add("${breed.key} $it")
            }
        }
    }
    return newList
}