package com.paizuri.taskreminder.di

import android.content.Context
import androidx.room.Room
import com.paizuri.taskreminder.database.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class TaskDatabaseModule {

    @Singleton
    @Provides
    fun provideTaskDatabase(@ApplicationContext context: Context): TaskDatabase {
        return Room.databaseBuilder(context, TaskDatabase::class.java, "task_reminder_db").build()
    }
}