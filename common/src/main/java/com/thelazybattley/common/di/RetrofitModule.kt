package com.thelazybattley.common.di

import com.thelazybattley.common.network.repository.CommonRepository
import com.thelazybattley.common.network.repository.impl.CommonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RetrofitModule {

    @Binds
    abstract fun bindCommonRepository(impl: CommonRepositoryImpl): CommonRepository
}
