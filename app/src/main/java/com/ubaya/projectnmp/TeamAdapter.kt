package com.ubaya.projectnmp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectnmp.databinding.OurScheduleCardBinding
import com.ubaya.projectnmp.databinding.TeamCardBinding

class TeamAdapter()
    : RecyclerView.Adapter<TeamAdapter.QuestionViewHolder>() {
    class QuestionViewHolder(val binding: TeamCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = TeamCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return WhatWePlayData.whatWePlayDatas.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) { // set
        val data = WhatWePlayData.whatWePlayDatas[position]

        // Loop melalui setiap tim di dalam data.teams
        data.teams.forEach { (teamName, members) ->
            // Buat button baru secara programatis
            val teamButton = Button(holder.itemView.context).apply {
                text = teamName // Set nama tim sebagai teks di button
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                setOnClickListener {
                    // Aksi ketika button tim diklik
                    val intent = Intent(holder.itemView.context, TeamActivity::class.java)
                    intent.putExtra("teamName", teamName)
                    intent.putExtra("teamMembers", ArrayList(members))
                    holder.itemView.context.startActivity(intent)
                }
            }
        }
    }
}