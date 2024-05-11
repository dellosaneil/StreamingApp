package com.thelazybattley.movie.presentation.dashboard

import com.thelazybattley.common.base.BaseUiState
import com.thelazybattley.movies.data.item.movies.Movie

data class DashboardUiState(
    val isLoading: Boolean = true,
    val nowShowingMovies: List<Movie> = emptyList(),
    val popularMovies: List<Movie> = emptyList(),
    val topRatedMovies: List<Movie> = emptyList(),
    val upcomingMovies: List<Movie> = emptyList(),
    val trendingMovies: List<Movie> = emptyList()
) : BaseUiState
