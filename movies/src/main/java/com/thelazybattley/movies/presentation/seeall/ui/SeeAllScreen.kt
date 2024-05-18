package com.thelazybattley.movies.presentation.seeall.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.thelazybattley.movies.presentation.seeall.SeeAllEvents
import com.thelazybattley.movies.presentation.seeall.SeeAllUiState
import com.thelazybattley.movies.presentation.seeall.SeeAllViewModel

@Composable
fun SeeAllScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<SeeAllViewModel>()
    val uiState by viewModel.state.collectAsState()
    val event by viewModel.events.collectAsState(initial = null)

    SeeAllScreen(
        modifier = modifier,
        uiState = uiState,
        events = event
    )
}

@Composable
fun SeeAllScreen(
    modifier: Modifier = Modifier,
    uiState: SeeAllUiState,
    events: SeeAllEvents?
) {

}
