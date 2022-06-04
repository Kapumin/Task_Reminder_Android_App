package com.paizuri.taskreminder.common.base_classes

import androidx.lifecycle.ViewModel
import com.paizuri.taskreminder.common.dispatcher_provider.DispatcherProvider
import kotlinx.coroutines.*

abstract class BaseViewModel(private val dispatcherProvider: DispatcherProvider) : ViewModel() {

    private val job: Job = Job()
    private val viewModelScope = CoroutineScope(dispatcherProvider.main + job)

    open fun runBackground(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(dispatcherProvider.background, block = block)
    }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}