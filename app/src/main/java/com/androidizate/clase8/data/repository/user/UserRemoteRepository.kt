package com.androidizate.clase8.data.repository.user

import com.androidizate.clase8.data.datasources.remote.RestApiClient
import com.androidizate.clase8.data.datasources.remote.dtos.toUser
import com.androidizate.clase8.data.datasources.remote.dtos.toUserResponse
import com.androidizate.clase8.domain.entities.User
import com.androidizate.clase8.domain.repositories.UserRepository

class UserRemoteRepository(
    private val service: RestApiClient
) : UserRepository {

    override suspend fun createUser(user: User) {
        service.createUser(user.toUserResponse())
    }

    override suspend fun getUser(id: Long): User {
        return service.getUser(id).toUser()
    }

    override suspend fun updateUser(user: User) {
        service.updateUser(user.id, user.toUserResponse())
    }

    override suspend fun deleteUser(id: Long) {
        service.deleteUser(id)
    }

    override suspend fun getAllUsers(): List<User> {
        return service.getAllUsers().map { it.toUser() }
    }
}
