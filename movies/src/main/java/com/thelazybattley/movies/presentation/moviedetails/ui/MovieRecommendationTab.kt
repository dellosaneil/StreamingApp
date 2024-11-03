package com.thelazybattley.movies.presentation.moviedetails.ui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.thelazybattley.common.presentation.navigation.NavScreens
import com.thelazybattley.common.presentation.theme.MovieTheme
import com.thelazybattley.common.presentation.util.MoviePoster
import com.thelazybattley.movies.domain.item.recommendations.RecommendationsData
import com.thelazybattley.movies.domain.item.recommendations.RecommendationsResult

@Composable
fun MovieRecommendationTab(
    modifier: Modifier = Modifier,
    recommendationsData: RecommendationsData,
    onNavigate: (String) -> Unit
) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(count = 2)) {
        items(recommendationsData.results, key = { it.id }) { recommendation ->
            MoviePoster(
                posterImage = recommendation.posterImage,
                voteAverage = recommendation.voteAverage,
                onMovieClicked = {
                    onNavigate(NavScreens.MovieDetails.args(id = recommendation.id))
                },
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMovieRecommendationTab() {
    MovieTheme {
        MovieRecommendationTab(
            modifier = Modifier,
            recommendationsData = RecommendationsData(
                results = listOf(
                    RecommendationsResult(
                        id = 1,
                        posterImage = "https://img.pikbest.com/origin/09/28/01/64CpIkbEsTGtN.png!w700wp",
                        title = "Random",
                        voteAverage = 6.1
                    ),
                    RecommendationsResult(
                        id = 2,
                        posterImage = "https://img.pikbest.com/origin/09/28/01/64CpIkbEsTGtN.png!w700wp",
                        title = "Testing",
                        voteAverage = 6.3
                    ), RecommendationsResult(
                        id = 3,
                        posterImage = "https://img.pikbest.com/origin/09/28/01/64CpIkbEsTGtN.png!w700wp",
                        title = "Question",
                        voteAverage = 6.0
                    )
                )
            )
        ) {

        }
    }
}
