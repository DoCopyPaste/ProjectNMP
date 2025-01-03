package com.ubaya.projectnmp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.projectnmp.databinding.FragmentWhatWePlayBinding
import org.json.JSONObject



class WhatWePlayFragment : Fragment() {
    private lateinit var binding:FragmentWhatWePlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

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
                        Toast.makeText(requireContext(), "Failed to fetch games", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(requireContext(), "Error parsing games", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(requireContext(), "Error fetching games: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )

        Volley.newRequestQueue(requireContext()).add(stringRequest)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentWhatWePlayBinding.inflate(inflater,container,false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateList()
    }
    fun updateList() {
        val lm = LinearLayoutManager(activity)
        with(binding.recWhatWePlay) {
            layoutManager = lm
            setHasFixedSize(true)
            fetchGames()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WhatWePlayFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}