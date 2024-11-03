package com.thelazybattley.movies.presentation.seeall.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.thelazybattley.common.presentation.navigation.NavScreens
import com.thelazybattley.common.presentation.theme.colors
import com.thelazybattley.common.presentation.util.MoviePoster
import com.thelazybattley.movies.domain.item.movies.Movie
import com.thelazybattley.movies.presentation.seeall.SeeAllEvents
import com.thelazybattley.movies.presentation.seeall.SeeAllUiState
import com.thelazybattley.movies.presentation.seeall.SeeAllViewModel

@Composable
fun SeeAllScreen(
    modifier: Modifier = Modifier,
    onNavigate: (String) -> Unit,
    onBackButtonPressed: () -> Unit
) {
    val viewModel = hiltViewModel<SeeAllViewModel>()
    val uiState by viewModel.state.collectAsState()
    val event by viewModel.events.collectAsState(initial = null)
    val movies = viewModel.movies.collectAsLazyPagingItems()

    SeeAllScreen(
        modifier = modifier,
        uiState = uiState,
        events = event,
        movies = movies,
        onNavigate = onNavigate,
        onBackButtonPressed = {
            onBackButtonPressed()
        }
    )
}

@Composable
fun SeeAllScreen(
    modifier: Modifier = Modifier,
    uiState: SeeAllUiState,
    events: SeeAllEvents?,
    movies: LazyPagingItems<Movie>,
    onNavigate: (String) -> Unit,
    onBackButtonPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            SeeAllTopBar(
                modifier = Modifier,
                movieGroupType = uiState.movieGroupType,
                onBackButtonClicked = {
                    onBackButtonPressed()
                },
                onSearchClicked = {

                }
            )
        },
        containerColor = colors.white1,
        modifier = Modifier.fillMaxSize()
    ) { paddingValues: PaddingValues ->
        LazyVerticalGrid(
            modifier = modifier.fillMaxSize(),
            columns = GridCells.Adaptive(minSize = 156.dp),
            contentPadding = paddingValues
        ) {
            items(movies.itemCount) {index ->
                val movie = movies[index]!!
                MoviePoster(
                    posterImage = movie.posterImage,
                    voteAverage = movie.voteAverage,
                    onMovieClicked = {
                        onNavigate(NavScreens.MovieDetails.args(id = movie.id))
                    },
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}
