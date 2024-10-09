package com.ubaya.projectnmp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AchievementDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_achievement_detail)

        // Terima data dari Intent
        val gameTitle = intent.getStringExtra("title")
        val gameImageId = intent.getIntExtra("image", 0)

        // Terima description yang dikirim sebagai ArrayList<HashMap<String, Any>>
        val descriptionList = intent.getSerializableExtra("desc") as? ArrayList<HashMap<String, Any>>

        // Konversi kembali ke List<Map<String, Any>>
        val descriptions = descriptionList?.map { it.toMap() }

        // Menggabungkan deskripsi dan tahun
        val descriptionText = descriptions?.joinToString("\n") {
            "${it["desc"]} (${it["year"]})"
        }

        // Set data ke elemen UI
        val titleTextView: TextView = findViewById(R.id.txtGameTitle) // Sesuaikan dengan id di XML
        val descriptionTextView: TextView = findViewById(R.id.txtGameDescription) // Sesuaikan dengan id di XML
        val imageView: ImageView = findViewById(R.id.imageView) // Sesuaikan dengan id di XML

        // Set title, description, dan image di UI
        titleTextView.text = gameTitle
        descriptionTextView.text = descriptionText
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
