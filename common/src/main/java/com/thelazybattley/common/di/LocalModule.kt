package com.thelazybattley.common.di

import android.content.Context
import androidx.room.Room
import com.thelazybattley.common.data.network.local.CommonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideCommonDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        CommonDatabase::class.java,
        "common_movie_db"
    )

    @Singleton
    @Provides
    fun provideGenreDao(db: CommonDatabase) = db.genreDao()

}
