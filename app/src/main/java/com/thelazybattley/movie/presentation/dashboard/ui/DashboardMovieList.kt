package com.thelazybattley.movie.presentation.dashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.thelazybattley.common.presentation.theme.MovieTheme
import com.thelazybattley.common.presentation.theme.colors
import com.thelazybattley.common.presentation.theme.textStyle
import com.thelazybattley.movie.R
import com.thelazybattley.movies.domain.item.movies.Movie

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DashboardMovieList(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    groupName: String
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
                modifier = Modifier.padding(end = 16.dp)
            )
        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 16.dp)
        ) {
            items(items = movies, key = { it.id }) { movie ->
                Box {
                    GlideImage(
                        model = movie.posterImage,
                        contentDescription = null,
                        modifier = Modifier
                            .height(250.dp)
                            .fillMaxWidth()
                            .padding(all = 4.dp)
                            .clip(shape = RoundedCornerShape(size = 12.dp)),
                        loading = placeholder(com.thelazybattley.common.R.drawable.image_loading_transparent)
                    )
                    Box(
                        modifier = Modifier
                            .offset(x = 16.dp, y = 16.dp)
                            .clip(shape = RoundedCornerShape(size = 6.dp))
                            .background(color = colors.red1)
                            .padding(all = 4.dp)
                    ) {
                        Text(
                            text = movie.voteAverage.toString(),
                            style = textStyle.urbanist.copy(
                                color = colors.white1,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }
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
                )
            )
        )
    }
}
