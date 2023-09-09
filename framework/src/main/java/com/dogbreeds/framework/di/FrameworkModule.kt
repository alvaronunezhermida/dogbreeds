package com.dogbreeds.framework.di

import com.dogbreeds.data.source.BreedsRemoteDataSource
import com.dogbreeds.framework.remote.BreedsApi
import com.dogbreeds.framework.remote.clients.BreedsClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FrameworkModule  {

    /*@Provides
    @Singleton
    fun provideDatabase(app: Application) = Room.databaseBuilder(
        app,
        MovieDatabase::class.java,
        "movie-db"
    ).build()

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieDatabase) = db.movieDao()*/

    @Provides
    @Singleton
    @ApiUrl
    fun provideApiUrl(): String = "https://dog.ceo/api/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    @Provides
    @Singleton
    fun provideRemoteService(@ApiUrl apiUrl: String, okHttpClient: OkHttpClient): BreedsApi {
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
            .create(BreedsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: BreedsApi): BreedsRemoteDataSource {
        return BreedsClient(apiService)
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class AppDataModule {

    @Binds
    abstract fun provideRemoteDataSource(breedsRemoteDataSource: BreedsClient): BreedsRemoteDataSource

}