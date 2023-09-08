package com.dogbreeds.framework.remote

import com.dogbreeds.framework.remote.models.BreedsResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface BreedsApi {

    @GET("breeds/list/all")
    suspend fun getAllBreeds(): Response<BreedsResponseDTO>

}