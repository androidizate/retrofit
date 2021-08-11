package com.androidizate.clase8.repositories.datasources.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
class PostEntity(
    @PrimaryKey var id: Int,
    var userId: Int,
    var title: String = "",
    var body: String = "",
)
