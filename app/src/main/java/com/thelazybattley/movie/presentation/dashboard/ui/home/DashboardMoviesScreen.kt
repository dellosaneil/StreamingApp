package com.thelazybattley.movie.presentation.dashboard.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thelazybattley.common.presentation.navigation.NavScreens
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
                groupName = stringResource(id = MovieGroupType.NOW_SHOWING.text)
            ) {
                onNavigate(NavScreens.SeeAll.args(type = MovieGroupType.NOW_SHOWING.toString()))
            }
        }

        item {
            DashboardMovieList(
                modifier = Modifier
                    .padding(top = 8.dp),
                movies = uiState.upcomingMovies,
                groupName = stringResource(id = MovieGroupType.UPCOMING.text)
            ) {
                onNavigate(NavScreens.SeeAll.args(type = MovieGroupType.UPCOMING.toString()))
            }
        }

        item {
            DashboardMovieList(
                modifier = Modifier
                    .padding(top = 8.dp),
                movies = uiState.popularMovies,
                groupName = stringResource(id = MovieGroupType.POPULAR.text)
            ) {
                onNavigate(NavScreens.SeeAll.args(type = MovieGroupType.POPULAR.toString()))
            }
        }

        item {
            DashboardMovieList(
                modifier = Modifier
                    .padding(top = 8.dp),
                movies = uiState.topRatedMovies,
                groupName = stringResource(id = MovieGroupType.TOP_RATED.text)
            ) {
                onNavigate(NavScreens.SeeAll.args(type = MovieGroupType.TOP_RATED.toString()))
            }
        }

        item {
            DashboardMovieList(
                modifier = Modifier
                    .padding(top = 8.dp),
                movies = uiState.trendingMovies,
                groupName = stringResource(id = MovieGroupType.TRENDING.text)
            ) {
                onNavigate(NavScreens.SeeAll.args(type = MovieGroupType.TRENDING.toString()))
            }
        }
    }
}
