package com.dogbreeds.data.repository

import arrow.core.Either
import arrow.core.left
import com.dogbreeds.domain.Error
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    protected fun <T> doRun(block: () -> Flow<Either<Error, T>>): Flow<Either<Error, T>> = block()
        .catch {
            emit(Error.Unknown.left())
        }.flowOn(Dispatchers.IO)

}