package com.thelazybattley.common.usecase

interface GetImageFromPath {

    operator fun invoke(path: String, width: Int) : String
}
