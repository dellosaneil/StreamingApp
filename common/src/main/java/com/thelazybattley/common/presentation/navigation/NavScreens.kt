package com.thelazybattley.common.presentation.navigation

sealed class NavScreens(
    val route: String,
    val routeWithArgs: String = route
) {

    companion object {
        const val ID = "id"
        const val TYPE = "type"
    }

    data object Dashboard : NavScreens(route = "dashboard")

    data object MovieDetails : NavScreens(
        route = "movieDetails",
        routeWithArgs = "movieDetails/{$ID}"
    ) {
        fun args(id: Int) = "${MovieDetails.route}/$id"
    }

    data object SeeAll : NavScreens(
        route = "seeAll",
        routeWithArgs = "seeAll/{$TYPE}"
    ) {
        fun args(type: String) = "${SeeAll.route}/$type"
    }

}
