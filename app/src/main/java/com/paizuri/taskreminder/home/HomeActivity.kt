package com.paizuri.taskreminder.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paizuri.taskreminder.R
import com.paizuri.taskreminder.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}