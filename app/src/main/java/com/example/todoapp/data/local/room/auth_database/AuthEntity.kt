package com.example.todoapp.data.local.room.auth_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class AuthEntity(
    @PrimaryKey val email: String,
    val name: String,
    val password: String
)