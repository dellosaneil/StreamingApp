package com.thelazybattley.movie.presentation.dashboard

import com.thelazybattley.common.base.BaseUiState
import com.thelazybattley.movies.data.item.movies.Movie

data class DashboardUiState(
    val isLoading: Boolean = true,
    val nowPlayingMovies: List<Movie> = emptyList()
    ) : BaseUiState
