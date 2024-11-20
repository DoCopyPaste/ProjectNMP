package com.ubaya.projectnmp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ubaya.projectnmp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val fragments: ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragments.add(WhatWePlayFragment())
        fragments.add(OurScheduleFragment())
        fragments.add(WhoWeAreFragment())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = MyAdapter(this, fragments)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNav.selectedItemId =
                    binding.bottomNav.menu.getItem(position).itemId
            }
        })

        binding.bottomNav.setOnItemSelectedListener {
            binding.viewPager.currentItem = when(it.itemId) {
                R.id.itemWhatWePlay -> 0
                R.id.itemOurSchedule -> 1
                R.id.itemWhoWeAre -> 2
                else -> 0 // default to home
            }
            true
        }

        binding.menuIcon.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(binding.drawer)) {
                binding.drawerLayout.closeDrawer(findViewById(R.id.drawer)) // Tutup jika sudah terbuka
            } else {
                binding.drawerLayout.openDrawer(findViewById(R.id.drawer)) // Buka jika tertutup
            }
        }

//        var eventFragmentList = WhatWePlayFragmentList.newInstance()
//        supportFragmentManager.beginTransaction().apply {
//            add(R.id.container, eventFragmentList)
//            commit()
//        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(binding.drawer)) {
            binding.drawerLayout.closeDrawer(binding.drawer)
        } else {
            super.onBackPressed()
        }
    }
}