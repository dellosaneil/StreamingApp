package com.thelazybattley.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.thelazybattley.common.R

val urbanist = GoogleFont("Urbanist")

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val urbanistFontFamily = FontFamily(
    Font(
        googleFont = urbanist,
        fontProvider = provider
    )
)

data class StreamingTypography(
    val urbanist : TextStyle = TextStyle(
        fontFamily = urbanistFontFamily
    )
)

val LocalTypography = staticCompositionLocalOf<StreamingTypography> { error("No typography provided") }

val textStyle: StreamingTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalTypography.current

