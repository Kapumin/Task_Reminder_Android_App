package com.paizuri.taskreminder.common.dispatcher_provider

import kotlinx.coroutines.CoroutineDispatcher

abstract class DispatcherProvider {
    abstract val main: CoroutineDispatcher
    abstract val background: CoroutineDispatcher
}