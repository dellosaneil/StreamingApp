package com.thelazybattley.movies.di

import com.thelazybattley.movies.data.network.service.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Singleton
    @Provides
    fun providesMoviesService(retrofit: Retrofit) = retrofit.create(MoviesService::class.java)
}
