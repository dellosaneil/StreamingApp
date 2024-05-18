package com.thelazybattley.common.data.network.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thelazybattley.common.data.network.local.genre.GenreDao
import com.thelazybattley.common.data.network.local.genre.GenreEntity

@Database(entities = [GenreEntity::class], version = 1)
abstract class CommonDatabase : RoomDatabase() {

    abstract fun genreDao(): GenreDao

}
