package com.dogbreeds.data.source

import arrow.core.Either
import com.dogbreeds.domain.*

interface BreedsRemoteDataSource {
    suspend fun getAllBreeds(): Either<Error, List<String>>
}