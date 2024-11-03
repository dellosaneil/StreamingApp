package com.thelazybattley.movies.presentation.moviedetails.ui

import androidx.compose.foundation.layout.PaddingValues
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
import com.thelazybattley.common.presentation.theme.colors
import com.thelazybattley.common.presentation.theme.textStyle
import com.thelazybattley.movies.R
import kotlinx.coroutines.launch

@Composable
fun MovieDetailsTab(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues
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
                        pagerState.scrollToPage(index)
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
        state = pagerState, modifier = modifier,
        contentPadding = contentPadding
    ) { index ->
        Text(text = tabItems[index])
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMovieDetailsTab() {
    MovieDetailsTab(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp, top = 16.dp)
    )
}
