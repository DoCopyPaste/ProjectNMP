package com.ubaya.projectnmp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.projectnmp.databinding.ActivityAchievementDetailBinding
import com.ubaya.projectnmp.databinding.ActivityTeamMemberBinding

class TeamMemberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamMemberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTeamMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val teamMember: ArrayList<TeamMember> = intent.getParcelableArrayListExtra("teamMember")!!
        val image = intent.getIntExtra("image", 0)
        if (image != 0) {
            binding.imageViewTeamMember.setImageResource(image)
        }
        val teamName = intent.getStringExtra("team")
        binding.txtTeamName.text = teamName

        binding.recTeamMember.layoutManager = LinearLayoutManager(this)
        binding.recTeamMember.setHasFixedSize(true)
        binding.recTeamMember.adapter = TeamMemberAdapter(teamMember)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}