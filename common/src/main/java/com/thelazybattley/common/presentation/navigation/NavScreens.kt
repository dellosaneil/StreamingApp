package com.thelazybattley.common.presentation.navigation

sealed class NavScreens(
    val route: String,
    val routeWithArgs: String = route
) {

    companion object {
        private const val ID_PARAM = "id"
    }

    data object Dashboard : NavScreens(route = "dashboard")

    data class MovieDetails(val id: Int) : NavScreens(route = "movieDetails", routeWithArgs = "movieDetails/{$ID_PARAM}")

}
