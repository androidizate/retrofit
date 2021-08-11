package com.androidizate.clase8.repositories.datasources.local

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidizate.clase8.repositories.datasources.local.daos.PostDao
import com.androidizate.clase8.repositories.datasources.local.daos.UserDao
import com.androidizate.clase8.repositories.datasources.local.entities.PostEntity
import com.androidizate.clase8.repositories.datasources.local.entities.UserEntity

@Database(
    entities = arrayOf(UserEntity::class, PostEntity::class ),
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun postDao(): PostDao

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
