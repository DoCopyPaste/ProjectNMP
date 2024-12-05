package com.ubaya.projectnmp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.projectnmp.Proposal
import com.ubaya.projectnmp.ProposalAdapter
import com.ubaya.projectnmp.databinding.ActivityApplyTeamBinding

class ApplyTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApplyTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menginisialisasi binding
        binding = ActivityApplyTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dummy data untuk daftar proposal
        val proposals = listOf(
            Proposal("League of Legends", "WAITING"),
            Proposal("League of Legends", "DECLINED"),
            Proposal("Mobile Legends", "GRANTED")
        )

        // Mengatur RecyclerView
        binding.proposalRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.proposalRecyclerView.adapter = ProposalAdapter(proposals)

        // Tindakan untuk tombol FAB
        binding.fab.setOnClickListener {
            val intent = Intent(this, ApplyTeamNewActivity::class.java)
            startActivity(intent)
        }
    }
}
