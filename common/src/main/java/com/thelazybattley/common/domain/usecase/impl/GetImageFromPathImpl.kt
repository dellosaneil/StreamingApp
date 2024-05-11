package com.thelazybattley.common.domain.usecase.impl

import com.thelazybattley.common.domain.usecase.GetImageFromPath
import javax.inject.Inject

class GetImageFromPathImpl @Inject constructor(): GetImageFromPath {

    companion object {
        const val BASE_PATH = "https://image.tmdb.org/t/p/original/"
    }

    override fun invoke(path: String): String = BASE_PATH + path
}
