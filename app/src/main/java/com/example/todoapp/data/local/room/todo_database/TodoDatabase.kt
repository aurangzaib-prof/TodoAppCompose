package com.example.todoapp.data.local.room.todo_database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TodoEntity::class],
    version = 1
)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}