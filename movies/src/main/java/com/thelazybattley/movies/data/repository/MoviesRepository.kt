package com.thelazybattley.movies.data.repository

import com.thelazybattley.common.domain.item.credits.CreditsData
import com.thelazybattley.movies.domain.item.moviedetails.MovieDetailsData
import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import com.thelazybattley.movies.domain.item.movies.MoviesData

interface MoviesRepository {

    suspend fun getMovieList(type: MovieGroupType, page : Int): Result<MoviesData>

    suspend fun getMovieDetails(id: Int): Result<MovieDetailsData>

    suspend fun getMovieCredits(id: Int): Result<CreditsData>
}
