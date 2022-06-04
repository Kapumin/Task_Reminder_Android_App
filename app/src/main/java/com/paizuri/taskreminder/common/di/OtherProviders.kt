package com.paizuri.taskreminder.di

import com.paizuri.taskreminder.common.dispatcher_provider.DispatcherProverImpl
import com.paizuri.taskreminder.common.dispatcher_provider.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class OtherProviders {

    @Provides
    fun provideDispatchProvider(): DispatcherProvider = DispatcherProverImpl()

}