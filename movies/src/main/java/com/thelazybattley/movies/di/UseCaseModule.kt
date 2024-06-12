package com.thelazybattley.movies.di

import com.thelazybattley.movies.data.network.usecase.GetMovieDetails
import com.thelazybattley.movies.data.network.usecase.GetMovieListUseCase
import com.thelazybattley.movies.data.network.usecase.impl.GetMovieDetailsImpl
import com.thelazybattley.movies.data.network.usecase.impl.GetMovieListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindsGetNowPlayingUseCase(impl: GetMovieListUseCaseImpl): GetMovieListUseCase

    @Binds
    abstract fun bindsGetMovieDetails(impl: GetMovieDetailsImpl) : GetMovieDetails
}
