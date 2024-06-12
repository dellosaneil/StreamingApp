package com.thelazybattley.movies.data.network.usecase

import com.thelazybattley.movies.domain.item.moviedetails.MovieDetailsData

interface GetMovieDetails {

    suspend operator fun invoke(id: Int) : Result<MovieDetailsData>
}
