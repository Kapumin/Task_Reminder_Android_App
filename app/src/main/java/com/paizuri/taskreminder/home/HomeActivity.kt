package com.paizuri.taskreminder.home

import android.os.Bundle
import androidx.activity.viewModels
import com.paizuri.taskreminder.R
import com.paizuri.taskreminder.common.adapters.HomeTaskListAdapter
import com.paizuri.taskreminder.common.base_classes.BaseActivity
import com.paizuri.taskreminder.common.entities.Task
import com.paizuri.taskreminder.common.extensions.showToast
import com.paizuri.taskreminder.common.helpers.DialogManager
import com.paizuri.taskreminder.databinding.ActivityHomeBinding
import com.paizuri.taskreminder.extensions.setOnClick
import com.paizuri.taskreminder.task_editor.TaskEditorActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity(), HomeTaskListAdapter.TaskClickListener {

    private lateinit var binding: ActivityHomeBinding

    private val homeActivityViewModel: HomeActivityViewModel by viewModels()

    private lateinit var adapter: HomeTaskListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObservers()
        setupRecyclerView()
        observeData()
        setClickListeners()
    }

    private fun setObservers() {
        homeActivityViewModel.getAllTasks()
    }

    private fun observeData() {
        homeActivityViewModel.tasksList.observe(this) { tasks ->
            if (tasks.isEmpty()) {
                showToast("No Tasks")
            } else {
                adapter.updateDataset(tasks)
                adapter.notifyItemRangeChanged(0, tasks.size)
            }
        }
    }

    private fun setupRecyclerView() {
        if (::adapter.isInitialized.not()) {
            adapter = HomeTaskListAdapter().apply {
                updateDataset(mutableListOf())
                setItemClickListener(this@HomeActivity)
                binding.rvTaskList.adapter = this
            }
        }
    }

    private fun setClickListeners() {
        binding.ivAddTask.setOnClick {
            TaskEditorActivity.start(this)
        }
    }

    override fun onResume() {
        homeActivityViewModel.getAllTasks()
        super.onResume()
    }

    override fun onTaskClicked(task: Task) {
        TaskEditorActivity.startActivityForEdit(this, true, task)
    }

    override fun onTaskChecked(task: Task, taskPosition: Int) {
        DialogManager.createDialog(this, getString(R.string.check_task_as_done), onPositiveButtonClicked = {
            homeActivityViewModel.deleteTask(task)
            adapter.removeTaskFromDataset(task, taskPosition)
        })
    }
}