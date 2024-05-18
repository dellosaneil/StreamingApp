package com.thelazybattley.movie.presentation.dashboard.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.thelazybattley.common.R
import com.thelazybattley.common.presentation.theme.colors
import com.thelazybattley.common.presentation.theme.textStyle

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    posterImage: String,
    voteAverage: Double
) {
    Box(modifier = modifier) {
        GlideImage(
            model = posterImage,
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .padding(all = 4.dp)
                .clip(shape = RoundedCornerShape(size = 12.dp)),
            loading = placeholder(R.drawable.image_loading_transparent)
        )
        Box(
            modifier = Modifier
                .offset(x = 16.dp, y = 16.dp)
                .clip(shape = RoundedCornerShape(size = 6.dp))
                .background(color = colors.red1)
                .padding(all = 4.dp)
        ) {
            Text(
                text = voteAverage.toString(),
                style = textStyle.urbanist.copy(
                    color = colors.white1,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}
