package com.thelazybattley.movies.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thelazybattley.common.presentation.theme.MovieTheme
import com.thelazybattley.common.presentation.theme.colors
import com.thelazybattley.common.presentation.theme.textStyle
import com.thelazybattley.common.presentation.util.MoviePoster
import com.thelazybattley.movies.R
import com.thelazybattley.movies.domain.item.movies.Movie

@Composable
fun DashboardMovieList(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    groupName: String,
    onNavigate: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 16.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = groupName,
                style = textStyle.urbanist.copy(
                    color = colors.black1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(start = 16.dp)
            )

            Text(
                text = stringResource(R.string.see_all),
                style = textStyle.urbanist.copy(
                    color = colors.red1,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                ),
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clip(shape = RoundedCornerShape(size = 8.dp))
                    .clickable {
                        onNavigate()
                    }
                    .padding(all = 4.dp)

            )
        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 16.dp)
        ) {
            items(items = movies, key = { it.id }) { movie ->
                MoviePoster(
                    modifier = Modifier,
                    posterImage = movie.posterImage,
                    voteAverage = movie.voteAverage
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDashboardMovieList() {
    MovieTheme {
        DashboardMovieList(
            groupName = "Now Playing",
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
                )
            )
        ) {

        }
    }
}
