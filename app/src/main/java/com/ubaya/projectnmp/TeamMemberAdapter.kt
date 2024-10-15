package com.ubaya.projectnmp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectnmp.databinding.ItemAchievementBinding
import com.ubaya.projectnmp.databinding.TeamMemberCardBinding

class TeamMemberAdapter (private var teamMembers: List<TeamMember>) :
    RecyclerView.Adapter<TeamMemberAdapter.TeamMemberViewHolder>() {
    class TeamMemberViewHolder(val binding: TeamMemberCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberViewHolder {
        val binding = TeamMemberCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TeamMemberViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return teamMembers.size
    }
    override fun onBindViewHolder(holder: TeamMemberViewHolder, position: Int) {
        val data = teamMembers[position]
        holder.binding.txtRole.text = data.role
        holder.binding.txtUsername.text = data.name
        holder.binding.imgAvatar.setImageResource(data.imageId)
    }
}