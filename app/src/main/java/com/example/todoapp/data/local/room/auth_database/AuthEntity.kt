package com.example.todoapp.data.local.room.auth_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "auth_table")
data class AuthEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val email: String,
    val name: String,
    val password: String
)

fun AuthEntity.toUser(): User {
    return User(
        username = name,
        email = email
    )
}
