package com.androidizate.clase8.data.datasources.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidizate.clase8.data.datasources.local.daos.UserDao
import com.androidizate.clase8.data.datasources.local.entities.UserEntity

@Database(
    entities = arrayOf(UserEntity::class),
    version = 2,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var appDatabase: AppDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): AppDatabase {
            return appDatabase ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java, "app-database"
            ).build()
        }
    }
}
