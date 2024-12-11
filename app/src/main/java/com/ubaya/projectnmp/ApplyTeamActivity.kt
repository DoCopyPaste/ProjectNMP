package com.ubaya.projectnmp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubaya.projectnmp.databinding.ActivityApplyTeamBinding
import org.json.JSONArray
import org.json.JSONObject

class ApplyTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApplyTeamBinding
    private val proposals = mutableListOf<Proposal>()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        // Menginisialisasi binding
        binding = ActivityApplyTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur RecyclerView
        binding.proposalRecyclerView.layoutManager = LinearLayoutManager(this)

        // Panggil fungsi untuk mengambil data dari API
        fetchProposals()

        // Tindakan untuk tombol FAB
        binding.fab.setOnClickListener {
            val intent = Intent(this, ApplyTeamNewActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchProposals() {
        val url = "https://ubaya.xyz/native/160422011/get_proposals_by_member.php" // Ganti dengan URL API Anda

        // Kirim request ke server
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                try {
                    val jsonResponse = JSONObject(response)
                    val status = jsonResponse.getString("status")

                    if (status == "OK") {
                        val proposalsArray = jsonResponse.getJSONArray("proposals")
                        parseProposals(proposalsArray)
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
                val id = sharedPreferences.getString("user_id", null)
                params["idmember"] = id!!
                return params
            }
        }

        // Tambahkan request ke antrian
        Volley.newRequestQueue(this).add(stringRequest)
    }

    private fun parseProposals(proposalsArray: JSONArray) {
        proposals.clear()
        for (i in 0 until proposalsArray.length()) {
            val proposalObj = proposalsArray.getJSONObject(i)
            val gameName = proposalObj.getString("game_name")
            val status = proposalObj.getString("status")
            proposals.add(Proposal(gameName, status))
        }

        // Perbarui RecyclerView dengan data yang baru
        binding.proposalRecyclerView.adapter = ProposalAdapter(proposals)
    }
}
