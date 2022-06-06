package com.paizuri.taskreminder.common.helpers

import kotlin.random.Random

const val EDIT_TASK = "edit_task"
const val TASK_TITLE = "task_title"
const val TASK_DESCRIPTION = "task_description"
const val IS_EDIT_TASK = "is_edit_task"

var DEFAULT_TASK_TITLE = "Task".plus(Random.nextInt(1000000).toString())