package com.ubaya.projectnmp

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.projectnmp.databinding.ActivitySchedulePageDetailBinding

class SchedulePageDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchedulePageDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulePageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      binding.scheduleTitle.text = intent.getStringExtra("schedule")
        binding.eventTitle.text = intent.getStringExtra("title")
        binding.eventLocationTime.text = intent.getStringExtra("location")
        binding.eventTeam.text = intent.getStringExtra("team")
        binding.eventDescription.text = intent.getStringExtra("desc")
        val imageId = intent.getIntExtra("image", 0)

        if (imageId != 0) {
            findViewById<ImageView>(R.id.eventImage).setImageResource(imageId)
        }
        Log.d("DetailActivity", "Received Image ID: $imageId")

        binding.likeButton.setOnClickListener {
            showNotificationDialog()
        }
    }

    private fun showNotificationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Notification Created")
        builder.setMessage("Your schedule notification has been created.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}
