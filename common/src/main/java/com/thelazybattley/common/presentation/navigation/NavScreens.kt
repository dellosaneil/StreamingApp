package com.thelazybattley.common.presentation.navigation

sealed class NavScreens(
    val route: String,
    val routeWithArgs: String = route
) {

    companion object {
        private const val ID_PARAM = "id"
        const val TYPE = "type"
    }

    data object Dashboard : NavScreens(route = "dashboard")

    data object MovieDetails : NavScreens(
        route = "movieDetails",
        routeWithArgs = "movieDetails/{$ID_PARAM}"
    )

    data object SeeAll : NavScreens(
        route = "seeAll",
        routeWithArgs = "seeAll/{$TYPE}"
    ) {
        fun args(type: String) = "seeAll/$type"
    }

}
