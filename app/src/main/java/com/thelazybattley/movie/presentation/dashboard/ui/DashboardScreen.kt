package com.thelazybattley.movie.presentation.dashboard.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thelazybattley.common.presentation.theme.MovieTheme
import com.thelazybattley.movie.presentation.dashboard.DashboardEvent
import com.thelazybattley.movie.presentation.dashboard.DashboardUiState
import com.thelazybattley.movie.presentation.dashboard.DashboardViewModel
import com.thelazybattley.movie.presentation.dashboard.ui.home.DashboardMoviesScreen


@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<DashboardViewModel>()
    val uiState by viewModel.state.collectAsState()
    val events by viewModel.events.collectAsState(initial = null)

    DashboardScreen(
        modifier = modifier, uiState = uiState, event = events
    )
}

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    uiState: DashboardUiState,
    event: DashboardEvent?
) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier,
        bottomBar = {
            DashboardBottomNavigation(navController = navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = DashboardScreens.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(DashboardScreens.Home.route) { DashboardMoviesScreen(uiState = uiState) }
            composable(DashboardScreens.Favorites.route) { Text("Favorite") }
            composable(DashboardScreens.Search.route) { Text("Search") }
        }
    }
}


@Preview
@Composable
private fun PreviewDashboard() {
    MovieTheme {
        DashboardScreen(
            uiState = DashboardUiState(

            ),
            event = null
        )
    }
}
