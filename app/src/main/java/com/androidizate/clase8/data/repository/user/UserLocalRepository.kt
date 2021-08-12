package com.androidizate.clase8.data.repository.user

import com.androidizate.clase8.data.datasources.local.daos.UserDao
import com.androidizate.clase8.data.datasources.local.entities.toDbEntity
import com.androidizate.clase8.data.datasources.local.entities.toUser
import com.androidizate.clase8.domain.entities.User
import com.androidizate.clase8.domain.repositories.UserRepository

class UserLocalRepository(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun createUser(user: User) {
        userDao.insertAll(user.toDbEntity())
    }

    override suspend fun getUser(id: Long): User {
        return userDao.getUser(id).toUser()
    }

    override suspend fun updateUser(user: User) {
        userDao.updateUser(user.toDbEntity())
    }

    override suspend fun deleteUser(id: Long) {
        userDao.deleteUser(id)
    }

    override suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers().map { it.toUser() }
    }
}
