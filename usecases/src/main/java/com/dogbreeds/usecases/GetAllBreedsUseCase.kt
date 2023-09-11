package com.dogbreeds.usecases

import arrow.core.Either
import com.dogbreeds.data.repository.BreedsRepository
import com.dogbreeds.domain.Breed
import com.dogbreeds.domain.Error
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllBreedsUseCase @Inject constructor(private val breedsRepository: BreedsRepository) :
    BaseUseCase<Void, List<Breed>>() {

    override fun run(params: Void?): Flow<Either<Error, List<Breed>>> =
        breedsRepository.getAllBreeds()
}