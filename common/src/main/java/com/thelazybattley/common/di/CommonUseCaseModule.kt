package com.thelazybattley.common.di

import com.thelazybattley.common.domain.usecase.GetGenreListUseCase
import com.thelazybattley.common.domain.usecase.GetImageFromPath
import com.thelazybattley.common.domain.usecase.InsertGenreList
import com.thelazybattley.common.domain.usecase.impl.GetGenreListUseCaseImpl
import com.thelazybattley.common.domain.usecase.impl.GetImageFromPathImpl
import com.thelazybattley.common.domain.usecase.impl.InsertGenreListImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CommonUseCaseModule {

    @Binds
    abstract fun bindsGetImageFromPath(impl: GetImageFromPathImpl) : GetImageFromPath

    @Binds
    abstract fun bindsGetGenreList(impl: GetGenreListUseCaseImpl) : GetGenreListUseCase

    @Binds
    abstract fun bindsInsertGenreList(impl: InsertGenreListImpl) : InsertGenreList
}
