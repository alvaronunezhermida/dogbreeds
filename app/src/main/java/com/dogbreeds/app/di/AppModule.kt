package com.dogbreeds.app.di

import com.dogbreeds.app.navigation.AppNavigator
import com.dogbreeds.data.source.BreedsRemoteDataSource
import com.dogbreeds.app.data_implementation.remote.BreedsApi
import com.dogbreeds.app.data_implementation.remote.clients.BreedsClient
import com.dogbreeds.app.navigation.ActivityNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppNavigator(): AppNavigator {
        return AppNavigator()
    }

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
    fun provideBreedsApi(@ApiUrl apiUrl: String, okHttpClient: OkHttpClient): BreedsApi {
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(BreedsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBreedsRemoteDataSource(breedsClient: BreedsClient): BreedsRemoteDataSource =
        breedsClient
}