package com.thelazybattley.movies.presentation.moviedetails.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.thelazybattley.movies.R
import com.thelazybattley.movies.domain.item.recommendations.RecommendationsData
import com.thelazybattley.movies.domain.item.recommendations.RecommendationsResult
import com.thelazybattley.movies.domain.item.reviews.ReviewData
import kotlinx.coroutines.launch

@Composable
fun MovieDetailsTab(
    modifier: Modifier = Modifier,
    recommendationsData: RecommendationsData?,
    reviewData: ReviewData?,
    onNavigate: (String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    val tabItems = listOf(
        stringResource(R.string.trailers),
        stringResource(R.string.more_like_this),
        stringResource(R.string.comments)
    )

    val pagerState = rememberPagerState(initialPage = 0) { tabItems.size }
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = colors.white1,
        contentColor = colors.red1,
        indicator = { tabPositions ->
            if (pagerState.currentPage < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .clip(shape = RoundedCornerShape(size = 100.dp)),
                    color = colors.red1,
                    height = 4.dp
                )
            }
        },
        divider = {
            HorizontalDivider(
                thickness = 2.dp,
                color = colors.white2
            )
        }
    ) {
        tabItems.forEachIndexed { index, title ->
            Tab(
                selected = index == pagerState.currentPage,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = title,
                        style = textStyle.urbanist.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            )
        }
    }
    HorizontalPager(
        state = pagerState, modifier = modifier
    ) { index ->
        when (index) {
            0 -> {
                Text(text = tabItems[index])
            }

            1 -> {
                if (recommendationsData != null) {
                    MovieRecommendationTab(
                        modifier = Modifier,
                        recommendationsData = recommendationsData,
                        onNavigate = onNavigate
                    )
                }
            }

            2 -> {
                if(reviewData != null) {
                    MovieCommentsTab(
                        modifier = Modifier,
                        reviewData = reviewData
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMovieDetailsTab() {
    MovieTheme {
        MovieDetailsTab(
            modifier = Modifier.fillMaxSize(),
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
            ),
            reviewData = null
        ) {

        }
    }
}
