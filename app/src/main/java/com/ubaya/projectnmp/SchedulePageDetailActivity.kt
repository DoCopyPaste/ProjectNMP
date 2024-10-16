package com.ubaya.projectnmp

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.projectnmp.databinding.ActivitySchedulePageDetailBinding
import java.util.Date

class SchedulePageDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchedulePageDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulePageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val time = OurScheduleData.getFormattedTime(Date(intent.getLongExtra("date", 0L)))
//      binding.scheduleTitle.text = intent.getStringExtra("schedule")
        binding.eventTitle.text = intent.getStringExtra("title")
        binding.eventLocationTime.text = intent.getStringExtra("location") + " (${time})"
        binding.eventTeam.text = intent.getStringExtra("team")
        binding.eventDescription.text = intent.getStringExtra("desc")
        val imageId = intent.getIntExtra("image", 0)

        if (imageId != 0) {
            binding.eventImage.setImageResource(imageId)
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
}
