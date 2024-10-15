package com.ubaya.projectnmp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WhoWeAreActivity : AppCompatActivity() {
    private var likeCount = 0
    private val PREFS_NAME = "likePrefs"
    private val LIKE_KEY = "likeCount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_who_we_are)

        // Load the saved likeCount from SharedPreferences
        val prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        likeCount = prefs.getInt(LIKE_KEY, 0)

        // Set window insets and padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val likeButton = findViewById<Button>(R.id.likeButton)
        likeButton.text = "($likeCount)"

        likeButton.setOnClickListener {
            likeCount++
            likeButton.text = "($likeCount)"

            // Save the updated likeCount to SharedPreferences
            val editor = prefs.edit()
            editor.putInt(LIKE_KEY, likeCount)
            editor.apply()
        }
    }
}
