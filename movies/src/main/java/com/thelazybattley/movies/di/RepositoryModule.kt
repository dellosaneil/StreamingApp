package com.thelazybattley.movies.di

import com.thelazybattley.movies.data.repository.MoviesRepository
import com.thelazybattley.movies.data.repository.impl.MoviesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsMoviesRepository(impl: MoviesRepositoryImpl) : MoviesRepository
}
