package com.androidizate.clase8.repositories.datasources.remote.dtos

import com.androidizate.clase8.repositories.datasources.local.entities.UserEntity

/**
 * Created by andres.oller on 18/08/17.
 */
data class User(
    var id: Long = 0L,
    var name: String = "",
    var username: String = "",
    var email: String = "",
    var address: Address = Address(),
    var phone: String = "",
    var website: String = "",
    var company: Company = Company()
)

fun User.toDbEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email,
        phone = this.phone,
        website = this.website,
    )
}

fun UserEntity.toUser(): User {
    return User(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email,
        phone = this.phone,
        website = this.website,
    )
}