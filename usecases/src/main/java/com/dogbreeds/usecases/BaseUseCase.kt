package com.dogbreeds.usecases

import arrow.core.Either
import arrow.core.left
import com.dogbreeds.domain.Error
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<in P, out M>(
    private val dispatcher: CoroutineContext = Dispatchers.Default
) {

    operator fun invoke(params: P? = null): Flow<Either<Error, M>> = run(params = params)
        .catch { emit(Error.Unknown.left()) }
        .flowOn(context = dispatcher)

    protected abstract fun run(params: P?): Flow<Either<Error, M>>

}