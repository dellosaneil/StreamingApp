package com.thelazybattley.movies.presentation.moviedetails.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.thelazybattley.common.R
import com.thelazybattley.common.presentation.theme.MovieTheme
import com.thelazybattley.common.presentation.theme.colors
import com.thelazybattley.common.presentation.theme.textStyle
import com.thelazybattley.movies.domain.item.reviews.ReviewAuthorDetails
import com.thelazybattley.movies.domain.item.reviews.ReviewData
import com.thelazybattley.movies.domain.item.reviews.ReviewResult

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieCommentsTab(
    modifier: Modifier = Modifier,
    reviewData: ReviewData
) {
    LazyColumn(modifier = modifier) {
        items(items = reviewData.results, key = { it.id }) { review ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp, end = 16.dp,
                        top = 16.dp
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(space = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GlideImage(
                        model = review.authorDetails
                            .avatarPath,
                        contentDescription = null,
                        loading = placeholder(R.drawable.image_loading_transparent),
                        modifier = Modifier
                            .size(size = 48.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = review.author,
                        style = textStyle.urbanist.copy(
                            color = colors.black1,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = review.content,
                    style = textStyle.urbanist.copy(
                        color = colors.black1,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(thickness = 1.dp)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMovieCommentsTab() {
    MovieTheme {
        MovieCommentsTab(
            modifier = Modifier.fillMaxSize(),
            reviewData = ReviewData(
                id = 1,
                results = listOf(
                    ReviewResult(
                        authorDetails = ReviewAuthorDetails(
                            avatarPath = "a",
                            rating = 3
                        ),
                        content = "Content 1",
                        createdAt = "",
                        author = "Author",
                        id = "23"
                    ),
                    ReviewResult(
                        authorDetails = ReviewAuthorDetails(
                            avatarPath = "a",
                            rating = 5
                        ),
                        content = "Conten 2",
                        createdAt = "",
                        author = "Author 2",
                        id = "223"
                    ),
                    ReviewResult(
                        authorDetails = ReviewAuthorDetails(
                            avatarPath = "a",
                            rating = 3
                        ),
                        content = "Content 34",
                        createdAt = "",
                        author = "Author 3",
                        id = "1231"
                    )
                ),
                totalResults = 3
            )
        )
    }
}
