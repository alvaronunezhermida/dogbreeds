package com.dogbreeds.data.repository

import arrow.core.Either
import com.dogbreeds.data.source.BreedsRemoteDataSource
import com.dogbreeds.domain.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BreedsRepository(
    private val breedsRemote: BreedsRemoteDataSource,
    //private val breedsLocal: BreedsLocalDataSource
) : BaseRepository() {

    fun getAllBreeds(): Flow<Either<Error, List<String>>> = doRun {
        flow {
            emit(breedsRemote.getAllBreeds())
        }
    }

}