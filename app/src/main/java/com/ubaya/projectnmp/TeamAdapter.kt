package com.ubaya.projectnmp

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectnmp.databinding.OurScheduleCardBinding
import com.ubaya.projectnmp.databinding.TeamCardBinding

class TeamAdapter(private var teams: List<Team>, private var imageGameId: Int)
    : RecyclerView.Adapter<TeamAdapter.QuestionViewHolder>() {
    class QuestionViewHolder(val binding: TeamCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = TeamCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) { // set
        val data = teams[position]
//        val index = position + 1
//        Log.d("TEAM", teams.map { it.name }.toString())
//        Log.d("index", index.toString())
        holder.binding.btnTeamA.text = data.name
        holder.binding.btnTeamA.setOnClickListener {
            val intent = Intent(holder.itemView.context, TeamMemberActivity::class.java)
            intent.putExtra("team", data.name)
            intent.putParcelableArrayListExtra("teamMember", ArrayList<TeamMember>(data.teamMember))
            intent.putExtra("image", imageGameId)
            holder.itemView.context.startActivity(intent)
        }
    }
}