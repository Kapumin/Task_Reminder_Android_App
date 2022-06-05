package com.paizuri.taskreminder.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paizuri.taskreminder.dao.TaskDao
import com.paizuri.taskreminder.common.entities.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}