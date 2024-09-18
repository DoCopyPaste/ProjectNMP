package com.ubaya.projectnmp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.projectnmp.databinding.ActivityOurScheduleBinding

class OurScheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOurScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOurScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.textViewTitle.setOnClickListener {

            val intent = Intent(this, SchedulePageDetailActivity::class.java)
            startActivity(intent)
        }
    }
}
