package com.thelazybattley.movies.presentation.moviedetails.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.thelazybattley.common.presentation.theme.colors
import com.thelazybattley.common.presentation.theme.textStyle
import com.thelazybattley.common.presentation.util.CommonChip
import com.thelazybattley.common.presentation.util.CommonCreditChip
import com.thelazybattley.movies.R
import com.thelazybattley.movies.presentation.moviedetails.MovieDetailsCallbacks
import com.thelazybattley.movies.presentation.moviedetails.MovieDetailsState
import com.thelazybattley.movies.presentation.moviedetails.MovieDetailsViewModel

@Composable
fun MovieDetailsScreen(
    onNavigate: (String) -> Unit
) {
    val viewModel = hiltViewModel<MovieDetailsViewModel>()
    val uiState by viewModel.state.collectAsState()

    MovieDetailsScreen(
        uiState = uiState,
        callbacks = viewModel
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieDetailsScreen(
    uiState: MovieDetailsState,
    callbacks: MovieDetailsCallbacks
) {
    if (uiState.movieDetails == null) return
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colors.white1)
    ) {
        item {
            GlideImage(
                model = uiState.movieDetails.backdropImage,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 256.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(
                text = uiState.movieDetails.title,
                style = textStyle.urbanist.copy(
                    color = colors.black1,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                item {
                    val icon = painterResource(id = com.thelazybattley.common.R.drawable.ic_star)
                    Icon(
                        painter = icon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(size = 30.dp)
                            .padding(end = 8.dp),
                        tint = colors.red1.copy(
                            alpha = 0.4f
                        )
                    )
                    Text(
                        text = uiState.movieDetails.voteAverage.toString(),
                        style = textStyle.urbanist.copy(
                            color = colors.red1,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        ),
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = uiState.movieDetails.releaseYear.toString(),
                        style = textStyle.urbanist.copy(
                            color = colors.black1,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                }
                items(items = uiState.movieDetails.genres, key = { it.id }) { genre ->
                    CommonChip(text = genre.name)
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .animateContentSize(),
                text = uiState.movieDetails.overview,
                style = textStyle.urbanist.copy(
                    color = colors.gray2,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = (0.2).sp
                ),
                maxLines = uiState.maxLines,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = { result ->
                    callbacks.hasTextOverflow(result.hasVisualOverflow)
                }
            )

            if (uiState.hasTextOverflow) {
                Text(
                    text = stringResource(id = R.string.show_more),
                    style = textStyle.urbanist.copy(
                        color = colors.red1,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = (0.2).sp
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clickable {
                            callbacks.showMoreTextClicked()
                        }
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                modifier = Modifier,
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(items = uiState.credits?.crew ?: emptyList(), key = { it.id }) { crew ->
                    CommonCreditChip(
                        modifier = Modifier.padding(end = 8.dp),
                        name = crew.name,
                        department = crew.knownForDepartment,
                        image = crew.profilePath,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                items(items = uiState.credits?.cast ?: emptyList(), key = { it.id }) { cast ->
                    CommonCreditChip(
                        modifier = Modifier.padding(end = 8.dp),
                        name = cast.name,
                        department = cast.knownForDepartment,
                        image = cast.profilePath,
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            MovieDetailsTab(
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}
