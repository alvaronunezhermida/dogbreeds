package com.dogbreeds.framework.remote.clients

import arrow.core.Either
import com.dogbreeds.data.source.BreedsRemoteDataSource
import com.dogbreeds.domain.*
import com.dogbreeds.framework.remote.BaseRemote
import com.dogbreeds.framework.remote.BreedsApi
import com.dogbreeds.framework.remote.toDomain
import javax.inject.Inject

class BreedsClient @Inject constructor(
    private val breedsApi: BreedsApi,
) : BreedsRemoteDataSource, BaseRemote() {

    override suspend fun getAllBreeds(): Either<Error, List<String>> = doRun(
        getResponse = {
            breedsApi.getAllBreeds()
        },
        map = { dto ->
            dto.toDomain()
        }
    )
}