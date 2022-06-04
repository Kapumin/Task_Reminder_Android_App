package com.paizuri.taskreminder.home

import com.paizuri.taskreminder.entities.Task
import com.paizuri.taskreminder.repositories.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeActivityViewModel @Inject constructor(private val taskRepository: TaskRepository) {

    fun getAllTasks(): List<Task> = taskRepository.getAllTasks()

    fun insertTask(task: Task) = taskRepository.insertTask(task)

    fun updateTask(task: Task) = taskRepository.updateTask(task)

    fun deleteTask(task: Task) = taskRepository.deleteTask(task)
}
