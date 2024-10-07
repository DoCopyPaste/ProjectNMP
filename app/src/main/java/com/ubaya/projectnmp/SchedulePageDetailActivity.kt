package com.ubaya.projectnmp

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.projectnmp.databinding.ActivitySchedulePageDetailBinding

class SchedulePageDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchedulePageDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulePageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scheduleTitle.text = "Schedule Details"
        binding.eventTitle.text = "Regional Qualifier - Valorant"
        binding.eventLocationTime.text = "Los Angeles, CA (10.00 AM)"
        binding.eventTeam.text = "TEAM A"
        binding.eventDescription.text = "This high-stakes event will bring together top teams from across the region, all competing for a chance to advance to the national finals. Expect intense gameplay, strategic plays, and thrilling moments as teams battle it out in one of the most popular first-person shooters."

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
