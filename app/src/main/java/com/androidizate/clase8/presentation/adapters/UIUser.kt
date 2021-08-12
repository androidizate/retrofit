package com.androidizate.clase8.presentation.adapters

import com.androidizate.clase8.domain.entities.User

data class UIUser(
    val id: Long,
    val description: String
)

fun User.toUiUser(): UIUser {
    return UIUser(
        id = this.id,
        description = "${this.name} ${this.lastname} (${this.email})"
    )
}
