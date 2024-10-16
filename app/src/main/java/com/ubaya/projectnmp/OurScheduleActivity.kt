package com.ubaya.projectnmp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.projectnmp.databinding.ActivityOurScheduleBinding

class OurScheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOurScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOurScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val prefs = getSharedPreferences("likePrefs", MODE_PRIVATE)
//        val likeCount = prefs.getInt("likeCount", 0)
//
//        binding.scheduleTitle.text = likeCount.toString()
        binding.recOurSchedule.layoutManager = LinearLayoutManager(this)
        binding.recOurSchedule.setHasFixedSize(true)
        binding.recOurSchedule.adapter = OurScheduleAdapter()
    }
}
