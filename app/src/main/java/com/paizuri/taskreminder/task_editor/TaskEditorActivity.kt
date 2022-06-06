package com.paizuri.taskreminder.task_editor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.R.anim.abc_fade_in
import com.google.android.material.R.anim.abc_fade_out
import com.paizuri.taskreminder.common.base_classes.BaseActivity
import com.paizuri.taskreminder.databinding.ActivityTaskEditorBinding
import com.paizuri.taskreminder.common.entities.Task
import com.paizuri.taskreminder.common.helpers.*
import com.paizuri.taskreminder.extensions.setOnClick
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskEditorActivity : BaseActivity() {

    private val viewModel: TaskEditorViewModel by viewModels()

    private lateinit var binding: ActivityTaskEditorBinding
    private lateinit var editTask: Task
    private var isEditTask: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        catchIntentExtras()
        setClickListeners()
    }

    private fun catchIntentExtras() {
        intent?.let { intent ->
            isEditTask = intent.getBooleanExtra(IS_EDIT_TASK, false)
            if (isEditTask) {
                editTask = intent.getSerializableExtra(EDIT_TASK) as Task
                prepareLayoutForEdit()
            }
        }
    }

    private fun prepareLayoutForEdit() {
        binding.etTaskTitle.setText(editTask.taskTitle)
        binding.etTaskDescription.setText(editTask.taskDescription)
    }

    private fun setClickListeners() {
        binding.ivBack.setOnClick {
            saveTaskAndFinish()
        }
        binding.tvSaveTask.setOnClick {
            saveTaskAndFinish()
        }
    }

    private fun saveTaskAndFinish() {
        val task = getInput()
        task?.let {
            task.let { newTask ->
                newTask[TASK_TITLE]?.let { title ->
                    newTask[TASK_DESCRIPTION]?.let { description ->
                        if (isEditTask.not()) {
                            viewModel.insertTask(Task(null, taskTitle = title, taskDescription = description))
                        } else {
                            editTask.taskTitle = title
                            editTask.taskDescription = description
                            viewModel.updateTask(editTask)
                        }
                        super.onBackPressed()
                    }
                }
            }
        } ?: let {
            super.onBackPressed()
        }
    }

    private fun getInput(): HashMap<String, String>? {
        return if (isUserInputEmpty().not()) {
            HashMap<String, String>().apply {
                if (isTaskTitleEmpty()) {
                    this[TASK_TITLE] = DEFAULT_TASK_TITLE
                } else {
                    this[TASK_TITLE] = binding.etTaskTitle.text.toString()
                }
                this[TASK_DESCRIPTION] = binding.etTaskDescription.text.toString()
            }
        } else {
            null
        }
    }

    private fun isUserInputEmpty(): Boolean =
        binding.etTaskDescription.text.toString().trim().isEmpty() && binding.etTaskTitle.text.toString().trim().isEmpty()

    private fun isTaskTitleEmpty(): Boolean = (binding.etTaskTitle.text.toString().trim().isEmpty())

    override fun onBackPressed() {
        if (isUserInputEmpty()) {
            super.onBackPressed()
        } else {
            saveTaskAndFinish()
        }
    }

    companion object {

        fun start(activity: Activity, isEditTask: Boolean = false) {
            activity.apply {
                startActivity(Intent(activity, TaskEditorActivity::class.java).apply {
                    this.putExtra(IS_EDIT_TASK, isEditTask)
                })
                overridePendingTransition(abc_fade_in, abc_fade_out)
            }
        }

        fun startActivityForEdit(activity: Activity, isEditTask: Boolean = false, task: Task) {
            activity.apply {
                startActivity(Intent(activity, TaskEditorActivity::class.java).apply {
                    this.putExtra(EDIT_TASK, task)
                    this.putExtra(IS_EDIT_TASK, isEditTask)
                })
                overridePendingTransition(abc_fade_in, abc_fade_out)
            }
        }
    }
}