package com.example.todoapp.data.repository

import com.example.todoapp.data.local.room.auth_database.AuthEntity
import com.example.todoapp.data.local.room.auth_database.AuthDao

class AuthRepository(private val authDao: AuthDao) {
    suspend fun register(authEntity: AuthEntity): Result<Unit> {
        return try {
            authDao.registerUser(authEntity)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun login(email: String, password: String): Result<AuthEntity> {
        val user = authDao.getUserByEmail(email)
        return if (user != null && user.password == password) {
            Result.success(user)
        } else {
            Result.failure(Exception("Invalid email or password"))
        }
    }
}
