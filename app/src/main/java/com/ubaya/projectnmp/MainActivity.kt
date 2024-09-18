package com.ubaya.projectnmp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.projectnmp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.whatWePlayIcon.setOnClickListener {
            startActivity(Intent(this, WhatWePlayActivity::class.java))
        }
        binding.whatWePlayText.setOnClickListener {
            startActivity(Intent(this, WhatWePlayActivity::class.java))
        }

        binding.whoWeAreIcon.setOnClickListener {
            startActivity(Intent(this, WhoWeAreActivity::class.java))
        }
        binding.whoWeAreText.setOnClickListener {
            startActivity(Intent(this, WhoWeAreActivity::class.java))
        }

        binding.ourScheduleIcon.setOnClickListener {
            startActivity(Intent(this, OurScheduleActivity::class.java))
        }
        binding.ourScheduleText.setOnClickListener {
            startActivity(Intent(this, OurScheduleActivity::class.java))
        }
    }
}