package com.ubaya.projectnmp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.projectnmp.R
import com.ubaya.projectnmp.WhoWeAreActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set click listeners
        findViewById<ImageView>(R.id.what_we_play_icon).setOnClickListener {
            startActivity(Intent(this, WhatWePlayActivity::class.java))
        }
        findViewById<TextView>(R.id.what_we_play_text).setOnClickListener {
            startActivity(Intent(this, WhatWePlayActivity::class.java))
        }

        findViewById<ImageView>(R.id.who_we_are_icon).setOnClickListener {
            startActivity(Intent(this, WhoWeAreActivity::class.java))
        }
        findViewById<TextView>(R.id.who_we_are_text).setOnClickListener {
            startActivity(Intent(this, WhoWeAreActivity::class.java))
        }

        findViewById<ImageView>(R.id.our_schedule_icon).setOnClickListener {
            startActivity(Intent(this, OurScheduleActivity::class.java))
        }
        findViewById<TextView>(R.id.our_schedule_text).setOnClickListener {
            startActivity(Intent(this, OurScheduleActivity::class.java))
        }
    }
}
