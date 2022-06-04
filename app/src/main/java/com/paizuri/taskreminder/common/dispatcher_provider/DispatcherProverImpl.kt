package com.paizuri.taskreminder.common.dispatcher_provider

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DispatcherProverImpl : DispatcherProvider() {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val background: CoroutineDispatcher
        get() = Dispatchers.Default;
}