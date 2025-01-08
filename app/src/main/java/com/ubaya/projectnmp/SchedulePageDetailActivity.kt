package com.ubaya.projectnmp

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.ubaya.projectnmp.databinding.ActivitySchedulePageDetailBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SchedulePageDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchedulePageDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulePageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val time = getFormattedTime(Date(intent.getLongExtra("schedule", 0L)))
//        binding.scheduleTitle.text = intent.getStringExtra("schedule")
        binding.eventTitle.text = intent.getStringExtra("title")
        binding.eventLocationTime.text = "Los Angeles" + " (${time})"
        Log.d("time", intent.getStringExtra("schedule")!!)
        binding.eventTeam.text = intent.getStringExtra("team")
        binding.eventDescription.text = intent.getStringExtra("description")
        val imageId = intent.getIntExtra("image", 0)

        if (imageId != 0) {
            val imageView = binding.eventImage
            Picasso.get()
                .load("file:///android_asset/games/${imageId}.png")
                .into(imageView)
        }
        Log.d("DetailActivity", "Received Image ID: $imageId")

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
