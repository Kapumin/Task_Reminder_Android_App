package com.paizuri.taskreminder.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey val taskId: Int,
    @ColumnInfo val taskTitle: String,
    @ColumnInfo val taskDescription: String
)