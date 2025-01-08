package com.ubaya.projectnmp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.projectnmp.databinding.ActivityApplyTeamNewBinding
import org.json.JSONObject

class ApplyTeamNewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApplyTeamNewBinding
    private var gamesList = mutableListOf<String>() // List untuk menyimpan nama game
    private var gamesMap = mutableMapOf<String, Int>() // Map untuk menyimpan idGame berdasarkan nama
    private var teamsList = mutableListOf<String>() // List untuk menyimpan nama tim
    private var teamsMap = mutableMapOf<String, Int>() // Map untuk menyimpan idTeam berdasarkan nama
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApplyTeamNewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        fetchGames() // Ambil data game dari server

        // Listener untuk Spinner Game
        binding.spnChooseGame.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) { // Ini dipakai agar "Choose Game" tidak dipilih
                    val selectedGame = gamesList[position]
                    val idGame = gamesMap[selectedGame] // Ambil idGame berdasarkan nama
                    fetchTeams(idGame!!) // Fetch teamm berdasarkan id game yang dipilih
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Listener untuk Spinner Team
        binding.spnChooseTeam.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) {
                    val selectedTeam = teamsList[position]
                    Toast.makeText(this@ApplyTeamNewActivity, "Selected Team: $selectedTeam", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        binding.btnApplyTeam.setOnClickListener {
            val idMember = sharedPreferences.getString("user_id", null)
            val selectedTeamPosition = binding.spnChooseTeam.selectedItemPosition

            if (selectedTeamPosition > 0) { // Pastikan tim sudah dipilih
                val selectedTeamName = binding.spnChooseTeam.selectedItem.toString()
                val idTeam = teamsMap[selectedTeamName] // Ambil idTeam dari map
                val description = binding.descField.text.toString() // Ambil deskripsi dari EditText
                val status = "waiting" // Status default saat mengajukan proposal

                if (description.isBlank()) {
                    Toast.makeText(this, "Please enter a description!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
 
                val url = "https://ubaya.xyz/native/160422011/apply_team.php"
                val stringRequest = object : StringRequest(
                    Method.POST, url,
                    { response ->
                        try {
                            val jsonResponse = JSONObject(response)
                            val status = jsonResponse.getString("status")
                            val message = jsonResponse.getString("message")

                            if (status == "OK") {
                                Toast.makeText(this, "Proposal submitted successfully!", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(this, "Error: $message", Toast.LENGTH_SHORT).show()
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                            Toast.makeText(this, "Error parsing response!", Toast.LENGTH_SHORT).show()
                        }
                    },
                    { error ->
                        Toast.makeText(this, "Error submitting proposal: ${error.message}", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    override fun getParams(): Map<String, String> {
                        val params = HashMap<String, String>()
                        params["idmember"] = idMember.toString()
                        params["idteam"] = idTeam.toString()
                        params["description"] = description
                        params["status"] = status
                        return params
                    }
                }

                Volley.newRequestQueue(this).add(stringRequest)
            } else {
                Toast.makeText(this, "Please select a team!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun fetchGames() {
        val url = "https://ubaya.xyz/native/160422011/get_games.php" // Ganti dengan URL API 1

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                try {
                    val jsonResponse = JSONObject(response)
                    val status = jsonResponse.getString("status")

                    if (status == "OK") {
                        val gamesArray = jsonResponse.getJSONArray("games")
                        gamesList.add("Choose Game") // Tambahkan opsi default
                        for (i in 0 until gamesArray.length()) {
                            val game = gamesArray.getJSONObject(i)
                            val idGame = game.getInt("idgame")
                            val name = game.getString("name")
                            gamesList.add(name)
                            gamesMap[name] = idGame
                        }
                        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, gamesList)
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        binding.spnChooseGame.adapter = adapter
                    } else {
                        Toast.makeText(this, "Failed to fetch games", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error parsing games", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(this, "Error fetching games: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )

        Volley.newRequestQueue(this).add(stringRequest)
    }

    private fun fetchTeams(idGame: Int) {
        val url = "https://ubaya.xyz/native/160422011/get_teams_by_game_based_member.php"

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            { response ->
                try {
                    val jsonResponse = JSONObject(response)
                    val status = jsonResponse.getString("status")

                    if (status == "OK") {
                        val teamsArray = jsonResponse.getJSONArray("teams")
                        teamsList.clear()
                        teamsMap.clear()
                        teamsList.add("Choose Team") // Tambahkan opsi default
                        for (i in 0 until teamsArray.length()) {
                            val team = teamsArray.getJSONObject(i)
                            val idTeam = team.getInt("idteam")
                            val name = team.getString("name")
                            teamsList.add(name)
                            teamsMap[name] = idTeam
                        }
                        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teamsList)
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        binding.spnChooseTeam.adapter = adapter
                        binding.spnChooseTeam.isEnabled = true
                    } else {
                        binding.spnChooseTeam.setSelection(0)
                        binding.spnChooseTeam.isEnabled = false
                        Toast.makeText(this, "No teams found", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error parsing teams", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(this, "Error fetching teams: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                val idMember = sharedPreferences.getString("user_id", null)
                params["idgame"] = idGame.toString()
                params["idmember"] = idMember.toString()
                return params
            }
        }

        Volley.newRequestQueue(this).add(stringRequest)
    }
}
