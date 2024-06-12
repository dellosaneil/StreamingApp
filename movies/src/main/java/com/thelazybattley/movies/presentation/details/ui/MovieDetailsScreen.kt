package com.thelazybattley.movies.presentation.details.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.thelazybattley.movies.presentation.details.MovieDetailsState
import com.thelazybattley.movies.presentation.details.MovieDetailsViewModel

@Composable
fun MovieDetailsScreen(
    onNavigate: (String) -> Unit,
    onBackButtonPressed: () -> Unit
) {
    val viewModel = hiltViewModel<MovieDetailsViewModel>()
    val uiState by viewModel.state.collectAsState()

    MovieDetailsScreen(uiState = uiState) {

    }


}

@Composable
fun MovieDetailsScreen(
    uiState: MovieDetailsState,
    onBackButtonPressed: () -> Unit
) {

}
