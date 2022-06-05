package com.paizuri.taskreminder.home

import androidx.lifecycle.MutableLiveData
import com.paizuri.taskreminder.common.base_classes.BaseViewModel
import com.paizuri.taskreminder.common.dispatcher_provider.DispatcherProvider
import com.paizuri.taskreminder.common.entities.Task
import com.paizuri.taskreminder.common.repositories.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeActivityViewModel @Inject constructor(private val taskRepository: TaskRepository, dispatcherProvider: DispatcherProvider) :
    BaseViewModel(dispatcherProvider) {

    var tasksList: MutableLiveData<List<Task>> = MutableLiveData()

    fun getAllTasks() {
        runBackground {
            tasksList.postValue(taskRepository.getAllTasks())
        }
    }


    fun deleteTask(task: Task) {
        runBackground {
            taskRepository.deleteTask(task)
        }
    }
}
