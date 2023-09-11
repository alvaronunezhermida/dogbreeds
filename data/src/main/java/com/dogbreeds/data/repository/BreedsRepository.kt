package com.dogbreeds.data.repository

import arrow.core.Either
import com.dogbreeds.data.source.BreedsRemoteDataSource
import com.dogbreeds.domain.Breed
import com.dogbreeds.domain.BreedImage
import com.dogbreeds.domain.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BreedsRepository @Inject constructor(
    private val breedsRemoteDataSource: BreedsRemoteDataSource,
    //private val breedsLocal: BreedsLocalDataSource
) : BaseRepository() {

    fun getAllBreeds(): Flow<Either<Error, List<Breed>>> = doRun {
        flow {
            emit(breedsRemoteDataSource.getAllBreeds())
        }
    }

    fun getBreedImages(breedName: String, quantity: Int): Flow<Either<Error, List<BreedImage>>> = doRun {
        flow {
            emit(breedsRemoteDataSource.getBreedImages(breedName, quantity))
        }
    }

}