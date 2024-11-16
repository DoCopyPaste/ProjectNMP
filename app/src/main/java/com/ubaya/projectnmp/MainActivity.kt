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

        binding.bottomNav.setOnItemSelectedListener {
            binding.main.currentItem = when(it.itemId) {
                R.id.itemWhatWePlay -> 0
                R.id.itemOurSchedule -> 1
                R.id.itemWhoWeAre -> 2
                else -> 0 // default to home
            }
            true
        }

        var eventFragmentList = EventFragmentList.newInstance(events)
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, eventFragmentList)
            commit()
        }
    }
}