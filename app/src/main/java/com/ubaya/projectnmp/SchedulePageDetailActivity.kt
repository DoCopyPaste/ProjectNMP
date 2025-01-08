package com.ubaya.projectnmp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.ubaya.projectnmp.databinding.ActivitySchedulePageDetailBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SchedulePageDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchedulePageDetailBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulePageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        val time = intent.getStringExtra("time")
//        binding.scheduleTitle.text = intent.getStringExtra("schedule")
        binding.eventTitle.text = intent.getStringExtra("title")
        binding.eventLocationTime.text = "Los Angeles" + " (${time})"
        binding.eventTeam.text = intent.getStringExtra("team")
        binding.eventDescription.text = intent.getStringExtra("description")
        val imageId = intent.getIntExtra("image", 0)

        if (imageId != 0) {
            val imageView = binding.eventImage
            Picasso.get()
                .load("file:///android_asset/games/${imageId}.png")
                .into(imageView)
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

        binding.likeButton.setOnClickListener {
            showNotificationDialog()
        }
    }

    private fun showNotificationDialog() {
        val builder = AlertDialog.Builder(this)
        val title = intent.getStringExtra("title")
        builder.setTitle("Schedule has been saved !")
        builder.setMessage("${title} has been set on your calendar")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }

    // Fungsi untuk mengambil jam dalam format "hh:mm a" (12-hour format dengan AM/PM)
    fun getFormattedTime(date: Date): String {
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.US)  // Format jam 12 dengan AM/PM
        return timeFormat.format(date)
    }
}
