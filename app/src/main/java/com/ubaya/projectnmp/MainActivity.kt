package com.ubaya.projectnmp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Example interactions
        findViewById<ImageView>(R.id.what_we_play_icon).setOnClickListener {
            Toast.makeText(this, "What We Play Clicked", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.who_we_are_icon).setOnClickListener {
            Toast.makeText(this, "Who We Are Clicked", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.our_schedule_icon).setOnClickListener {
            Toast.makeText(this, "Our Schedule Clicked", Toast.LENGTH_SHORT).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}