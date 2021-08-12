package com.androidizate.clase8.data.datasources.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androidizate.clase8.domain.entities.User

@Entity(tableName = "users")
class UserEntity(
    @PrimaryKey var id: Long,
    var name: String = "",
    var username: String = "",
    var email: String = "",
    var phone: String = "",
    var website: String = ""
)

fun User.toDbEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
        email = this.email
    )
}

fun UserEntity.toUser(): User {
    return User(
        id = this.id,
        name = this.name,
        email = this.email,
        lastname = ""
    )
}
