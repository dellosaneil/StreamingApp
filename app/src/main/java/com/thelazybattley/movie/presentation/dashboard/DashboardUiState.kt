package com.thelazybattley.movie.presentation.dashboard

import com.thelazybattley.common.domain.item.Genre
import com.thelazybattley.common.presentation.base.BaseUiState
import com.thelazybattley.movies.domain.item.movies.Movie

data class DashboardUiState(
    val isLoading: Boolean = true,
    val highlightedMovie: Movie? = null,
    val nowShowingMovies: List<Movie> = emptyList(),
    val popularMovies: List<Movie> = emptyList(),
    val topRatedMovies: List<Movie> = emptyList(),
    val upcomingMovies: List<Movie> = emptyList(),
    val trendingMovies: List<Movie> = emptyList(),
    val genres: List<Genre> = emptyList()
) : BaseUiState
