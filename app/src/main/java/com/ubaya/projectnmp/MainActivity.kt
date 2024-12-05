package com.ubaya.projectnmp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ubaya.projectnmp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val fragments: ArrayList<Fragment> = ArrayList()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("username", null)

        binding.username.text = "Welcome back, $name !"
//        // Check if user is already logged in
//        if (sharedPreferences.getBoolean("logged_in", false)) {
//            startActivity(Intent(this, SignInActivity::class.java))
//            finish()
//            return
//        }

        fragments.add(WhatWePlayFragment())
        fragments.add(OurScheduleFragment())
        fragments.add(WhoWeAreFragment())

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
        binding.btnSignOut.setOnClickListener {
            with(sharedPreferences.edit()) {
                putBoolean("logged_in", false)
                putString("user_id", null)
                apply()
            }
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
        binding.btnApplyTeam.setOnClickListener {
            val intent = Intent(this, ApplyTeamActivity::class.java)
            startActivity(intent)
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