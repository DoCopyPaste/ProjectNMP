package com.ubaya.projectnmp

import android.os.Bundle
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
import com.ubaya.projectnmp.databinding.ActivityAchievementDetailBinding
import com.ubaya.projectnmp.databinding.ActivityTeamMemberBinding
import org.json.JSONObject

class TeamMemberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamMemberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTeamMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intent.getIntExtra("image", 0)
        if (image != 0) {
            Picasso.get()
                .load("file:///android_asset/games/${image}.png")
                .into(binding.imageViewTeamMember)
        }
        val teamName = intent.getStringExtra("team")
        binding.txtTeamName.text = teamName

        val idTeam = intent.getIntExtra("idteam", 0)
        fetchTeamMember(idTeam)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun fetchTeamMember(idteam:Int) {
        val url = "https://ubaya.xyz/native/160422011/get_team_members.php" // Ganti dengan URL API Anda

        // Kirim request ke server
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                try {
                    val jsonResponse = JSONObject(response)
                    val status = jsonResponse.getString("status")

                    if (status == "OK") {
                        val teamMemberArray = jsonResponse.getJSONArray("team_members")
                        val teamMemberList = mutableListOf<TeamMember>()
                        for(i in 0 until teamMemberArray.length()){
                            val teamMemberObj = teamMemberArray.getJSONObject(i)
                            val team = TeamMember(
                                idMember = teamMemberObj.getInt("idmember"),
                                name = teamMemberObj.getString("name"),
                                description = teamMemberObj.getString("description")
                            )
                            teamMemberList.add(team)

                        }
                        binding.recTeamMember.layoutManager = LinearLayoutManager(this)
                        binding.recTeamMember.setHasFixedSize(true)
                        binding.recTeamMember.adapter = TeamMemberAdapter(teamMemberList)

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
                params["idteam"] = idteam.toString()
                return params
            }
        }

        // Tambahkan request ke antrian
        Volley.newRequestQueue(this).add(stringRequest)
    }
}
