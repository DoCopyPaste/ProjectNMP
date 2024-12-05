package com.ubaya.projectnmp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.projectnmp.databinding.ActivityApplyTeamNewBinding

class ApplyTeamNewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApplyTeamNewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityApplyTeamNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val games = listOf("Choose Game", "Valorant", "CS:GO", "Mobile Legends")
        val teams = listOf("Choose Team", "Team A", "Team B", "Team C")

        // Adapter spinner Game
        val gameAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, games)
        gameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnChooseGame.adapter = gameAdapter

        // Adapter spinner team
        val teamAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teams)
        teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnChooseTeam.adapter = teamAdapter

        // Listeners pinner game
        binding.spnChooseGame.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) { // "Choose Game" dipilih ga ngapa"in
                    Toast.makeText(this@ApplyTeamNewActivity, "Selected Game: ${games[position]}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        // Listener  spinner team
        binding.spnChooseTeam.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) {
                    Toast.makeText(this@ApplyTeamNewActivity, "Selected Team: ${teams[position]}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

//        setContentView(R.layout.activity_apply_team)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}