package com.paizuri.taskreminder.repositories

import com.paizuri.taskreminder.dao.TaskDao
import com.paizuri.taskreminder.entities.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    fun getAllTasks(): List<Task> = taskDao.getAllTasks()

    fun insertTask(task: Task) = taskDao.insertTask(task)

    fun updateTask(task: Task) = taskDao.updateTask(task)

    fun deleteTask(task: Task) = taskDao.deleteTask(task)

}