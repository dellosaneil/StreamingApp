package com.thelazybattley.common.di

import com.thelazybattley.common.domain.usecase.GetGenreList
import com.thelazybattley.common.domain.usecase.GetImageFromPath
import com.thelazybattley.common.domain.usecase.impl.GetGenreListImpl
import com.thelazybattley.common.domain.usecase.impl.GetImageFromPathImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindsGetImageFromPath(impl: GetImageFromPathImpl) : GetImageFromPath

    @Binds
    abstract fun bindsGetGenreList(impl: GetGenreListImpl) : GetGenreList
}
