package com.paizuri.taskreminder.home

import android.os.Bundle
import androidx.activity.viewModels
import com.paizuri.taskreminder.common.base_classes.BaseActivity
import com.paizuri.taskreminder.databinding.ActivityHomeBinding
import com.paizuri.taskreminder.extensions.setOnClick
import com.paizuri.taskreminder.task_editor.TaskEditorActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val homeActivityViewModel: HomeActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.ivAddTask.setOnClick {
            TaskEditorActivity.start(this)
        }
    }
}