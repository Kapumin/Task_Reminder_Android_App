package com.paizuri.taskreminder.common.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) var taskId: Int? = null,
    @ColumnInfo var taskTitle: String,
    @ColumnInfo var taskDescription: String
)