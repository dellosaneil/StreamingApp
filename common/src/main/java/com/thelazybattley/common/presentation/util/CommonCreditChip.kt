package com.thelazybattley.common.presentation.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CommonCreditChip(
    modifier: Modifier = Modifier,
    name: String,
    department: String,
    image: String
) {


    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            model = image, contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .size(size = 36.dp),
            loading = placeholder(R.drawable.image_loading_transparent),
            contentScale = ContentScale.Crop
        )
        Column(verticalArrangement = Arrangement.spacedBy(space = 4.dp)) {
            Text(
                text = name,
                style = textStyle.urbanist.copy(
                    color = colors.black1,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = department, style =
                textStyle.urbanist.copy(
                    color = colors.gray3,
                    fontSize = 10.sp,
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CommonCreditChipPreview() {
    MovieTheme {
        CommonCreditChip(
            modifier = Modifier.padding(end = 8.dp),
            name = "Testing",
            department = "Directing",
            image = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.freepik.com%2Ffree-photos-vectors%2Fcat-png&psig=AOvVaw1mRAuxyGxPAIYix6x_nAS6&ust=1719205400386000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCNi5qqv58IYDFQAAAAAdAAAAABAJ"
        )
    }
}
