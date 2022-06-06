package com.paizuri.taskreminder.task_editor

import com.paizuri.taskreminder.common.base_classes.BaseViewModel
import com.paizuri.taskreminder.common.dispatcher_provider.DispatcherProvider
import com.paizuri.taskreminder.common.entities.Task
import com.paizuri.taskreminder.common.repositories.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskEditorViewModel @Inject constructor(private val taskRepository: TaskRepository, dispatcherProvider: DispatcherProvider) :
    BaseViewModel(dispatcherProvider) {

    fun insertTask(task: Task) {
        runBackground {
            taskRepository.insertTask(task)
        }
    }

    fun updateTask(task: Task) {
        runBackground {
            taskRepository.updateTask(task)
        }
    }
}