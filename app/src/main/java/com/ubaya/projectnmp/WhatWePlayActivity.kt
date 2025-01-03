package com.ubaya.projectnmp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.projectnmp.databinding.ActivityWhatWePlayBinding
import org.json.JSONObject

class WhatWePlayActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWhatWePlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatWePlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.recWhatWePlay.layoutManager = LinearLayoutManager(this)
        binding.recWhatWePlay.setHasFixedSize(true)

        // Ambil gamenya
        fetchGames()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public class MyData {

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
                        val gamesList = mutableListOf<Game>()

                        for (i in 0 until gamesArray.length()) {
                            val gameObj = gamesArray.getJSONObject(i)
                            val game = Game(
                                idGame = gameObj.getInt("idgame"),
                                name = gameObj.getString("name"),
                                description = gameObj.getString("description")
                            )
                            gamesList.add(game)
                        }
                        binding.recWhatWePlay.adapter = WhatWePlayAdapter(gamesList)
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
}