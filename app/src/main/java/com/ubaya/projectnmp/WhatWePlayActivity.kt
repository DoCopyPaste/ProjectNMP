package com.ubaya.projectnmp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.projectnmp.databinding.ActivityWhatWePlayBinding

class WhatWePlayActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWhatWePlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatWePlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.recWhatWePlay.layoutManager = LinearLayoutManager(this)
        binding.recWhatWePlay.setHasFixedSize(true)
        binding.recWhatWePlay.adapter = WhatWePlayAdapter()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public class MyData {

    }
}