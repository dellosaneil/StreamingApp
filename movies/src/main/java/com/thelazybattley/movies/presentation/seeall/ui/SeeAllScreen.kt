package com.thelazybattley.movies.presentation.seeall.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.thelazybattley.common.presentation.theme.MovieTheme
import com.thelazybattley.common.presentation.theme.colors
import com.thelazybattley.common.presentation.util.MoviePoster
import com.thelazybattley.movies.domain.item.movies.Movie
import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import com.thelazybattley.movies.presentation.seeall.SeeAllEvents
import com.thelazybattley.movies.presentation.seeall.SeeAllUiState
import com.thelazybattley.movies.presentation.seeall.SeeAllViewModel

@Composable
fun SeeAllScreen(
    modifier: Modifier = Modifier,
    onBackButtonPressed: () -> Unit
) {
    val viewModel = hiltViewModel<SeeAllViewModel>()
    val uiState by viewModel.state.collectAsState()
    val event by viewModel.events.collectAsState(initial = null)

    SeeAllScreen(
        modifier = modifier,
        uiState = uiState,
        events = event,
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
            items(
                items = uiState.movies,
                key = { movie -> movie.id }
            ) { movie ->
                MoviePoster(
                    posterImage = movie.posterImage,
                    voteAverage = movie.voteAverage
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSeeAllScreen() {
    MovieTheme {
        SeeAllScreen(
            uiState = SeeAllUiState().copy(
                movieGroupType = MovieGroupType.TRENDING,
                movies = listOf(
                    Movie(
                        genreIds = listOf(1),
                        id = 23,
                        overview = "",
                        popularity = 32.1,
                        posterImage = "https://image.tmdb.org/t/p/w400//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                        releaseDate = "",
                        title = "Monkey",
                        voteAverage = 3.2,
                        backdropImage = "https://image.tmdb.org/t/p/w400//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                        genres = emptyList()
                    ),
                    Movie(
                        genreIds = listOf(1),
                        id = 21,
                        overview = "",
                        popularity = 32.1,
                        posterImage = "https://image.tmdb.org/t/p/w400//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                        releaseDate = "",
                        title = "Monkey",
                        voteAverage = 3.2,
                        backdropImage = "https://image.tmdb.org/t/p/w400//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                        genres = emptyList()
                    ),
                    Movie(
                        genreIds = listOf(1),
                        id = 1,
                        overview = "",
                        popularity = 32.1,
                        posterImage = "https://image.tmdb.org/t/p/w400//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                        releaseDate = "",
                        title = "Monkey",
                        voteAverage = 3.2,
                        backdropImage = "https://image.tmdb.org/t/p/w400//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                        genres = emptyList()
                    ),
                    Movie(
                        genreIds = listOf(1),
                        id = 2,
                        overview = "",
                        popularity = 32.1,
                        posterImage = "https://image.tmdb.org/t/p/w400//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                        releaseDate = "",
                        title = "Monkey",
                        voteAverage = 3.2,
                        backdropImage = "https://image.tmdb.org/t/p/w400//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                        genres = emptyList()
                    ),
                    Movie(
                        genreIds = listOf(1),
                        id = 6,
                        overview = "",
                        popularity = 32.1,
                        posterImage = "https://image.tmdb.org/t/p/w400//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                        releaseDate = "",
                        title = "Monkey",
                        voteAverage = 3.2,
                        backdropImage = "https://image.tmdb.org/t/p/w400//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                        genres = emptyList()
                    ),
                )
            ),
            events = null
        ) {

        }
    }
}
