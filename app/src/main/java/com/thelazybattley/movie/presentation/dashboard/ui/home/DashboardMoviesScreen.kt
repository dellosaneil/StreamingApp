package com.thelazybattley.movie.presentation.dashboard.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thelazybattley.common.presentation.theme.LocalColors
import com.thelazybattley.movie.presentation.dashboard.DashboardUiState
import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import com.thelazybattley.movies.presentation.home.DashboardHighlightedMovie
import com.thelazybattley.movies.presentation.home.DashboardMovieList
import com.thelazybattley.movies.presentation.util.text

@Composable
fun DashboardMoviesScreen(
    modifier: Modifier = Modifier,
    uiState: DashboardUiState,
    onNavigate: (String) -> Unit
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
            DashboardMovieList(
                modifier = Modifier
                    .padding(top = 8.dp),
                movies = uiState.nowShowingMovies,
                label = stringResource(id = MovieGroupType.NOW_SHOWING.text),
                groupName = MovieGroupType.NOW_SHOWING.groupName
            ) { route ->
                onNavigate(route)
            }
        }

        item {
            DashboardMovieList(
                modifier = Modifier
                    .padding(top = 8.dp),
                movies = uiState.upcomingMovies,
                label = stringResource(id = MovieGroupType.UPCOMING.text),
                groupName = MovieGroupType.UPCOMING.groupName
            ) { route ->
                onNavigate(route)
            }
        }

        item {
            DashboardMovieList(
                modifier = Modifier
                    .padding(top = 8.dp),
                movies = uiState.popularMovies,
                label = stringResource(id = MovieGroupType.POPULAR.text),
                groupName = MovieGroupType.POPULAR.groupName
            ) { route ->
                onNavigate(route)
            }
        }

        item {
            DashboardMovieList(
                modifier = Modifier
                    .padding(top = 8.dp),
                movies = uiState.topRatedMovies,
                label = stringResource(id = MovieGroupType.TOP_RATED.text),
                groupName = MovieGroupType.TOP_RATED.groupName
            ) { route ->
                onNavigate(route)
            }
        }

        item {
            DashboardMovieList(
                modifier = Modifier
                    .padding(top = 8.dp),
                movies = uiState.trendingMovies,
                label = stringResource(id = MovieGroupType.TRENDING.text),
                groupName = MovieGroupType.TRENDING.groupName
            ) { route ->
                onNavigate(route)
            }
        }
    }
}
