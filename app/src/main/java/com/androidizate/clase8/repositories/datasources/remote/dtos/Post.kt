package com.androidizate.clase8.repositories.datasources.remote.dtos

import com.androidizate.clase8.repositories.datasources.local.entities.PostEntity


data class Post(
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val body: String = ""
)


fun Post.toDbEntity(): PostEntity {
    return PostEntity(
        userId = this.userId,
        id = this.id,
        title = this.title,
        body = this.body,

    )
}

fun PostEntity.toPost(): Post {
    return Post(
        userId = this.userId,
        id = this.id,
        title = this.title,
        body = this.body,
    )
}