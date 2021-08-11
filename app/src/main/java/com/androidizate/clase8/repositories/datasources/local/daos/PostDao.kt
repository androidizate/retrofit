package com.androidizate.clase8.repositories.datasources.local.daos

import androidx.room.*
import com.androidizate.clase8.repositories.datasources.local.entities.PostEntity
import com.androidizate.clase8.repositories.datasources.local.entities.UserEntity

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg posts: PostEntity)

    @Delete
    suspend fun delete(post: PostEntity)

    @Query("SELECT * FROM posts")
    suspend fun getAll(): List<PostEntity>
}
