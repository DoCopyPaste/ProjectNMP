package com.ubaya.projectnmp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import com.ubaya.projectnmp.databinding.ActivityTeamBinding
import com.ubaya.projectnmp.databinding.ActivityWhatWePlayBinding
import org.json.JSONObject

class TeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val gameImageId = intent.getIntExtra("id", 0)

        // Jika gambar ada, tampilkan.
        if (gameImageId != 0) {
            val imageView = binding.imageView
            Picasso.get()
                .load("file:///android_asset/games/${gameImageId}.png")
                .into(imageView)
        }
        fetchTeams(gameImageId)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun fetchTeams(idgame:Int) {
        val url = "https://ubaya.xyz/native/160422011/get_teams_by_game.php" // Ganti dengan URL API Anda

        // Kirim request ke server
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                try {
                    val jsonResponse = JSONObject(response)
                    val status = jsonResponse.getString("status")

                    if (status == "OK") {
                        val teamsArray = jsonResponse.getJSONArray("teams")
                        val teamList = mutableListOf<Team>()
                        for(i in 0 until teamsArray.length()){
                            val teamObj = teamsArray.getJSONObject(i)
                            val team = Team(
                                idTeam = teamObj.getInt("idteam"),
                                name = teamObj.getString("name")
                            )
                            teamList.add(team)

                        }
                        binding.recTeam.layoutManager = LinearLayoutManager(this)
                        binding.recTeam.setHasFixedSize(true)
                        binding.recTeam.adapter = TeamAdapter(teamList, idgame)

                    } else {
                        val message = jsonResponse.getString("message")
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error parsing response", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        ) {
            // Kirim parameter GET
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["idgame"] = idgame.toString()
                return params
            }
        }

        // Tambahkan request ke antrian
        Volley.newRequestQueue(this).add(stringRequest)
    }
}