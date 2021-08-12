package com.androidizate.clase8.data.datasources.local.daos

import androidx.room.*
import com.androidizate.clase8.data.datasources.local.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg user: UserEntity)

    @Query("DELETE FROM users WHERE id =:id")
    suspend fun deleteUser(id: Long)

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id =:id")
    suspend fun getUser(id: Long): UserEntity

    @Update
    suspend fun updateUser(user: UserEntity)
}
