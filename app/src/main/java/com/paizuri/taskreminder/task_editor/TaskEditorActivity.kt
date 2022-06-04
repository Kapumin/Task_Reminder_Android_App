package com.paizuri.taskreminder.task_editor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.R.anim.abc_fade_in
import com.google.android.material.R.anim.abc_fade_out
import com.paizuri.taskreminder.common.base_classes.BaseActivity
import com.paizuri.taskreminder.databinding.ActivityTaskEditorBinding

class TaskEditorActivity : BaseActivity() {

    private lateinit var binding: ActivityTaskEditorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {

        fun start(activity: Activity) {
            activity.apply {
                startActivity(Intent(activity, TaskEditorActivity::class.java))
                overridePendingTransition(abc_fade_in, abc_fade_out)
            }
        }
    }
}