package com.dogbreeds.data.repository

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.dogbreeds.data.source.BreedsLocalDataSource
import com.dogbreeds.data.source.BreedsRemoteDataSource
import com.dogbreeds.domain.Breed
import com.dogbreeds.domain.BreedImage
import com.dogbreeds.domain.Empty
import com.dogbreeds.domain.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BreedsRepository @Inject constructor(
    private val breedsRemoteDataSource: BreedsRemoteDataSource,
    private val breedsLocalDataSource: BreedsLocalDataSource
) : BaseRepository() {

    val breeds: Flow<List<Breed>> = breedsLocalDataSource.breeds

    fun loadAllBreeds(): Flow<Either<Error, Empty>> = doRun {
        flow {
            if(breedsLocalDataSource.isBreedsListEmpty()) {
                val breeds = breedsRemoteDataSource.getAllBreeds()
                breeds.fold(
                    ifLeft = { emit(Error.Unknown.left()) },
                    ifRight = { breedsLocalDataSource.saveBreeds(it) }
                )
            }
        }
    }

    fun getBreedImages(breedName: String, quantity: Int): Flow<Either<Error, List<BreedImage>>> = doRun {
        flow {
            emit(breedsRemoteDataSource.getBreedImages(breedName, quantity))
        }
    }

}