package com.thelazybattley.common.usecase.impl

import com.thelazybattley.common.usecase.GetImageFromPath
import javax.inject.Inject

class GetImageFromPathImpl @Inject constructor(): GetImageFromPath {

    companion object {
        const val BASE_PATH = "https://image.tmdb.org/t/p/"
    }

    override fun invoke(path: String, width: Int) = BASE_PATH + "w$width$path"
}
