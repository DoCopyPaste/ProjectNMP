package com.ubaya.projectnmp

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AchievementDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_achievement_detail)

        // Terima data dari Intent
        val gameTitle = intent.getStringExtra("title")
        val gameImageId = intent.getIntExtra("image", 0)
        val description = intent.getStringExtra("description")
        @Suppress("UNCHECKED_CAST")
        val achievements = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("achievements", ArrayList::class.java) as? ArrayList<HashMap<String, Any>>
        } else {
            // Untuk API level di bawah 33
            intent.getSerializableExtra("achievements") as? ArrayList<HashMap<String, Any>>
        }

        // Set data ke elemen UI
        val titleTextView: TextView = findViewById(R.id.txtGameTitle) // Sesuaikan dengan id di XML
        val imageView: ImageView = findViewById(R.id.imageView) // Sesuaikan dengan id di XML
        val spinnerYear: Spinner = findViewById(R.id.spinnerYear)
        val recyclerViewAchievements: RecyclerView = findViewById(R.id.recycleViewAchievements)

        recyclerViewAchievements.layoutManager = LinearLayoutManager(this)

        val adapter = AchievementAdapter(achievements ?: emptyList())
        recyclerViewAchievements.adapter = adapter

        // Dapatkan tahun unik dari pencapaian
        val years = achievements?.map { it["year"].toString() }?.distinct()?.sorted()
        val yearOptions = listOf("All") + years.orEmpty()

        // Set data ke Spinner
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, yearOptions)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerYear.adapter = spinnerAdapter

        // Filter berdasarkan tahun
        spinnerYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedYear = yearOptions[position]
                val filteredAchievements = if (selectedYear == "All") {
                    achievements.orEmpty()
                } else {
                    achievements?.filter { it["year"].toString() == selectedYear }
                }

                // Update data di RecyclerView
                adapter.updateData(filteredAchievements.orEmpty())
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // Set title, description, dan image di UI
        titleTextView.text = gameTitle
        if (gameImageId != 0) {
            imageView.setImageResource(gameImageId)
        }


        // Mengatur padding untuk edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
