package com.thelazybattley.movie.presentation.dashboard.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.thelazybattley.common.theme.MovieTheme
import com.thelazybattley.common.theme.colors
import com.thelazybattley.common.theme.textStyle
import com.thelazybattley.movie.R
import com.thelazybattley.movies.data.item.movies.Movie

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DashboardHighlightedMovie(
    modifier: Modifier = Modifier,
    movie: Movie
) {
    ConstraintLayout(
        modifier = modifier
            .height(height = 256.dp)
    ) {
        val (image, title, genres) = createRefs()
        GlideImage(
            model = movie.backdropImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(ref = image) {
                    linkTo(start = parent.start, end = parent.end)
                    linkTo(top = parent.top, bottom = parent.bottom)
                    height = Dimension.fillToConstraints
                },
            loading = placeholder(R.drawable.ic_launcher_background),
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = movie.title,
            style = textStyle.urbanist.copy(
                color = colors.white1,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            modifier = Modifier.constrainAs(ref = title) {
                bottom.linkTo(anchor = genres.top, margin = 8.dp)
                start.linkTo(anchor = genres.start)
            },
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )

        Text(
            text = movie.genreIds.toString(),
            style = textStyle.urbanist.copy(
                color = colors.white1,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            ),
            modifier = Modifier.constrainAs(ref = genres) {
                bottom.linkTo(anchor = image.bottom, margin = 32.dp)
                start.linkTo(anchor = parent.start, margin = 16.dp)
            },
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewDashboardHighlightedMovie() {
    MovieTheme {
        DashboardHighlightedMovie(
            modifier = Modifier,
            movie = Movie(
                genreIds = listOf(1),
                id = 1,
                overview = "",
                popularity = 32.1,
                posterImage = "",
                releaseDate = "",
                title = "Monkey",
                voteAverage = 3.2,
                backdropImage = ""
            )
        )
    }

}
