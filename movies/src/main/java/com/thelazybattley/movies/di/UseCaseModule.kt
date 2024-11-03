package com.thelazybattley.movies.di

import com.thelazybattley.movies.data.network.usecase.FetchMovieCredits
import com.thelazybattley.movies.data.network.usecase.FetchMovieDetails
import com.thelazybattley.movies.data.network.usecase.FetchRecommendationsUseCase
import com.thelazybattley.movies.data.network.usecase.FetchReviews
import com.thelazybattley.movies.data.network.usecase.GetMovieListUseCase
import com.thelazybattley.movies.data.network.usecase.impl.FetchMovieCreditsImpl
import com.thelazybattley.movies.data.network.usecase.impl.FetchMovieDetailsImpl
import com.thelazybattley.movies.data.network.usecase.impl.FetchRecommendationsUseCaseImpl
import com.thelazybattley.movies.data.network.usecase.impl.FetchReviewsImpl
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
    abstract fun bindsGetMovieDetails(impl: FetchMovieDetailsImpl): FetchMovieDetails

    @Binds
    abstract fun bindsGetMovieCredits(impl: FetchMovieCreditsImpl): FetchMovieCredits

    @Binds
    abstract fun bindsFetchRecommendationsUseCase(impl: FetchRecommendationsUseCaseImpl): FetchRecommendationsUseCase

    @Binds
    abstract fun bindsFetchReviews(impl: FetchReviewsImpl): FetchReviews

}
