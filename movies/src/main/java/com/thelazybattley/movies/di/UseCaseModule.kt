package com.thelazybattley.movies.di

import com.thelazybattley.movies.data.network.usecase.GetNowPlayingUseCase
import com.thelazybattley.movies.data.network.usecase.impl.GetNowPlayingUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindsGetNowPlayingUseCase(impl: GetNowPlayingUseCaseImpl): GetNowPlayingUseCase
}
