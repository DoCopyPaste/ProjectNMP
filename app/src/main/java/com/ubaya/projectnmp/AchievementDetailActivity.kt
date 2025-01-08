package com.ubaya.projectnmp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import com.ubaya.projectnmp.databinding.ActivityAchievementDetailBinding
import com.ubaya.projectnmp.databinding.ActivityTeamBinding
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Locale

class AchievementDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAchievementDetailBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAchievementDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        // Terima data dari Intent
        val gameTitle = intent.getStringExtra("title")
        val gameId = intent.getIntExtra("id", 0)

        fetchAchievements(gameId)


        // Set title, description, dan image di UI
        binding.txtGameTitle.text = gameTitle
        if (gameId != 0) {
            val imageView = binding.imageView
            Picasso.get()
                .load("file:///android_asset/games/${gameId}.png")
                .into(imageView)
        }

        binding.menuIcon.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(binding.drawer)) {
                binding.drawerLayout.closeDrawer(findViewById(R.id.drawer)) // Tutup jika sudah terbuka
            } else {
                binding.drawerLayout.openDrawer(findViewById(R.id.drawer)) // Buka jika tertutup
            }
        }
        binding.btnSignOut.setOnClickListener {
            with(sharedPreferences.edit()) {
                putBoolean("logged_in", false)
                putString("user_id", null)
                apply()
            }
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
        binding.btnApplyTeam.setOnClickListener {
            val intent = Intent(this, ApplyTeamActivity::class.java)
            startActivity(intent)
        }

        // Mengatur padding untuk edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun  fetchAchievements(idgame: Int) {
        val url =
            "https://ubaya.xyz/native/160422011/get_achievements.php" // Ganti dengan URL API 1

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                try {
                    val jsonResponse = JSONObject(response)
                    val status = jsonResponse.getString("status")

                    if (status == "OK") {
                        val achievementArray = jsonResponse.getJSONArray("achievements")
                        val achievementList = mutableListOf<Achievement>()

                        for (i in 0 until achievementArray.length()) {
                            val achievementObj = achievementArray.getJSONObject(i)
                            val achievement = Achievement(
                                name = achievementObj.getString("name"),
                                year = achievementObj.getInt("year"),
                                team = achievementObj.getString("team")
                            )
                            achievementList.add(achievement)
                        }
                        binding.recycleViewAchievements.layoutManager = LinearLayoutManager(this)

                        val adapter = AchievementAdapter(achievementList ?: emptyList())
                        binding.recycleViewAchievements.adapter = adapter
                        // Dapatkan tahun unik dari pencapaian
                        val years =
                            achievementList?.map { it.year.toString() }?.distinct()?.sorted()
                        val yearOptions = listOf("All") + years.orEmpty()

                        // Set data ke Spinner
                        val spinnerAdapter =
                            ArrayAdapter(this, android.R.layout.simple_spinner_item, yearOptions)
                        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        binding.spinnerYear.adapter = spinnerAdapter

                        // Filter berdasarkan tahun
                        binding.spinnerYear.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(
                                    parent: AdapterView<*>,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ) {
                                    val selectedYear = yearOptions[position]
                                    val filteredAchievements = if (selectedYear == "All") {
                                        achievementList.orEmpty()
                                    } else {
                                        achievementList?.filter { it.year.toString() == selectedYear }
                                    }

                                    // Update data di RecyclerView
                                    adapter.updateData(filteredAchievements.orEmpty())
                                }

                                override fun onNothingSelected(parent: AdapterView<*>) {}
                            }
                    } else {
                        Toast.makeText(this, "Failed to fetch Achievements", Toast.LENGTH_SHORT)
                            .show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error parsing Achievements", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(
                    this,
                    "Error fetching Achievements: ${error.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            // Kirim parameter GET
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["idgame"] = idgame.toString()
                return params
            }
        }
        Volley.newRequestQueue(this).add(stringRequest)
    }
}
