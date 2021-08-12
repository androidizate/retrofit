package com.androidizate.clase8.data.datasources.remote.dtos

import com.androidizate.clase8.data.datasources.local.entities.UserEntity
import com.androidizate.clase8.domain.entities.User

/**
 * Created by andres.oller on 18/08/17.
 */
data class UserResponse(
    val id: Long = 0L,
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val address: Address = Address(),
    val phone: String = "",
    val website: String = "",
    val company: Company = Company()
)

data class Geo(
    val lat: String = "",
    val lng: String = ""
)

data class Company(
    val name: String = "",
    val catchPhrase: String = "",
    val bs: String = ""
)

data class Address(
    val street: String = "",
    val suite: String = "",
    val city: String = "",
    val zipcode: String = "",
    val geo: Geo = Geo()
)

fun UserResponse.toUser(): User {
    return User(
        id = this.id,
        name = this.name,
        email = this.email,
        lastname = ""
    )
}

fun User.toUserResponse(): UserResponse {
    return UserResponse(
        id = this.id,
        name = this.name,
        email = this.email
    )
}
