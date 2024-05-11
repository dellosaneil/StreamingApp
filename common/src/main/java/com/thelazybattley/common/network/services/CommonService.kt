package com.thelazybattley.common.network.services

import com.thelazybattley.common.network.response.genre.GenreDataResponse
import retrofit2.http.GET

interface CommonService {

    @GET("genre/movie/list")
    suspend fun getMoviesGenre() : GenreDataResponse
}
