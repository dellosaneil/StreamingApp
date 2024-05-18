package com.thelazybattley.movie.presentation.dashboard.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thelazybattley.common.presentation.theme.LocalColors
import com.thelazybattley.movie.R
import com.thelazybattley.movie.presentation.dashboard.DashboardUiState

@Composable
fun DashboardMoviesScreen(
    modifier: Modifier = Modifier,
    uiState: DashboardUiState
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = LocalColors.current.white1)
    ) {
        if (uiState.highlightedMovie != null) {
            item {
                DashboardHighlightedMovie(
                    modifier = modifier,
                    movie = uiState.highlightedMovie
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            DashboardMovieList(
                movies = uiState.nowShowingMovies,
                groupName = stringResource(R.string.now_showing)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DashboardMovieList(
                movies = uiState.upcomingMovies,
                groupName = stringResource(R.string.upcoming_movies)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DashboardMovieList(
                movies = uiState.popularMovies,
                groupName = stringResource(R.string.popular_movies)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DashboardMovieList(
                movies = uiState.topRatedMovies,
                groupName = stringResource(R.string.top_rated_movies)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DashboardMovieList(
                movies = uiState.trendingMovies,
                groupName = stringResource(R.string.trending_movies)
            )
        }
    }
}
