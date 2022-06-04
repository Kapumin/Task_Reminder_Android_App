package com.paizuri.taskreminder.dao

import androidx.room.*
import com.paizuri.taskreminder.entities.Task

@Dao
interface TaskDao {

    @Query("SELECT * from tasks")
    fun getAllTasks(): List<Task>

    @Insert
    fun insertTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}