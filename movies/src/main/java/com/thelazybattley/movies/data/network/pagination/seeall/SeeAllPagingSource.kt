package com.thelazybattley.movies.data.network.pagination.seeall

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.thelazybattley.movies.data.network.usecase.GetMovieListUseCase
import com.thelazybattley.movies.domain.item.movies.Movie
import com.thelazybattley.movies.domain.item.movies.MovieGroupType

class SeeAllPagingSource(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val type: MovieGroupType
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
      return  try {
            val nextPageNumber  = params.key ?: 1
            val response = getMovieListUseCase(type = type, page = nextPageNumber)
            return LoadResult.Page(
                data = response.getOrNull()?.results ?: emptyList(),
                prevKey = null,
                nextKey = nextPageNumber.inc()
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
