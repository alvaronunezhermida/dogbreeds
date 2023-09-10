package com.dogbreeds.app.data_implementation.remote

import com.dogbreeds.app.data_implementation.remote.models.BreedsResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface BreedsApi {

    @GET("breeds/list/all")
    suspend fun getAllBreeds(): Response<BreedsResponseDTO>

}