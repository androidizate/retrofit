package com.androidizate.clase8.domain.repositories

import com.androidizate.clase8.domain.entities.User

interface UserRepository {
    suspend fun createUser(user: User)

    suspend fun getUser(id: Long): User

    suspend fun updateUser(user: User)

    suspend fun deleteUser(id: Long)

    suspend fun getAllUsers(): List<User>
}
