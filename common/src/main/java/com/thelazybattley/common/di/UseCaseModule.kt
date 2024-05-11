package com.thelazybattley.common.di

import com.thelazybattley.common.usecase.GetImageFromPath
import com.thelazybattley.common.usecase.impl.GetImageFromPathImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindsGetImageFromPath(impl: GetImageFromPathImpl) : GetImageFromPath
}
