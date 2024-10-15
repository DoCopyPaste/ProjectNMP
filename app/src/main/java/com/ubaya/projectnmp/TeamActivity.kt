package com.ubaya.projectnmp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.projectnmp.databinding.ActivityTeamBinding
import com.ubaya.projectnmp.databinding.ActivityWhatWePlayBinding

class TeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val gameImageId = intent.getIntExtra("image", 0)
        val teams = intent.getSerializableExtra("teams") as HashMap<String, ArrayList<TeamMember>>
        // Jika gambar ada, tampilkan.
        if (gameImageId != 0) {
            binding.imageView .setImageResource(gameImageId)
        }
        teams.forEach { (teamName, members) ->
            println("Team: $teamName")
            members.forEach { member ->
                println("Member: ${member.name}, Role: ${member.role}, ImageId: ${member.imageId}")
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}