package com.thelazybattley.common.util

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url

        val requestBuilder = originalRequest.newBuilder()
            .addHeader(name = "Authorization", value = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMmMzZGRkYmEyYThiNTUzMDhmOTcyMzc2NTJkODE0MSIsInN1YiI6IjY2MzFiNzRiNDcwZWFkMDEyODEwNGFmNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.SEREeke0US_GlycVopRi_EmcfCdyzH9QJbN_3UJFNzo")
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
