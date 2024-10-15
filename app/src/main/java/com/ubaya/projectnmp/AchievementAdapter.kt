package com.ubaya.projectnmp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AchievementAdapter(private var achievements: List<Map<String, Any>>) :
    RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>() {

        class AchievementViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val txtAchievement: TextView = view.findViewById(R.id.txtAchievements)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_achievement, parent, false)
            return AchievementViewHolder(view)
        }

        override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
            val achievement = achievements[position]
            val index = position + 1
            holder.txtAchievement.text = "$index . ${achievement["achievement"]} (${achievement["year"]})"
        }

        override fun getItemCount(): Int {
            return achievements.size
        }

        // Update method to filter data
        fun updateData(newAchievements: List<Map<String, Any>>) {
            achievements = newAchievements
            notifyDataSetChanged()
        }
}