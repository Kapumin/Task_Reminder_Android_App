package com.paizuri.taskreminder.home

import androidx.lifecycle.MutableLiveData
import com.paizuri.taskreminder.common.base_classes.BaseViewModel
import com.paizuri.taskreminder.common.dispatcher_provider.DispatcherProvider
import com.paizuri.taskreminder.entities.Task
import com.paizuri.taskreminder.repositories.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeActivityViewModel @Inject constructor(private val taskRepository: TaskRepository, dispatcherProvider: DispatcherProvider) :
    BaseViewModel(dispatcherProvider) {

    private var tasksList: MutableLiveData<List<Task>> = MutableLiveData()

    fun getAllTasks() {
        runBackground {
            tasksList.postValue(taskRepository.getAllTasks())
        }
    }

    fun insertTask(task: Task) {
        runBackground {
            taskRepository.insertTask(task)
        }
    }

    fun updateTask(task: Task) = taskRepository.updateTask(task)

    fun deleteTask(task: Task) {
        runBackground {
            taskRepository.deleteTask(task)
        }
    }
}
