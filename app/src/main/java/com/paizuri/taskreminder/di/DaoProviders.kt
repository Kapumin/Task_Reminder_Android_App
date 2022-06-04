package com.paizuri.taskreminder.di

import com.paizuri.taskreminder.database.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [TaskDatabaseModule::class])
class DaoProviders {

    @Singleton
    @Provides
    fun provideTaskDao(taskDb: TaskDatabase) = taskDb.taskDao()
}