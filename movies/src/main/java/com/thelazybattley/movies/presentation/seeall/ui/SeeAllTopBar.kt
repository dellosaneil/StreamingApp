package com.thelazybattley.movies.presentation.seeall.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thelazybattley.common.R
import com.thelazybattley.common.presentation.theme.colors
import com.thelazybattley.common.presentation.theme.textStyle
import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import com.thelazybattley.movies.presentation.util.text

@Composable
fun SeeAllTopBar(
    modifier: Modifier = Modifier,
    movieGroupType: MovieGroupType?,
    onBackButtonClicked: () -> Unit,
    onSearchClicked: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colors.white1)
            .padding(
                all = 16.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space = 16.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = null,
            modifier = Modifier.clickable {
                onBackButtonClicked()
            }
        )
        if (movieGroupType != null) {
            Text(
                text = stringResource(id = movieGroupType.text),
                style = textStyle.urbanist.copy(
                    color = colors.black1,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier.clickable {
                onSearchClicked()
            }
        )
    }
}
