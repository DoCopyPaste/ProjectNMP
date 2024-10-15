package com.ubaya.projectnmp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectnmp.databinding.ItemAchievementBinding
import com.ubaya.projectnmp.databinding.OurScheduleCardBinding

class AchievementAdapter(private var achievements: List<Achievement>) :
    RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>() {
    class AchievementViewHolder(val binding: ItemAchievementBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        val binding = ItemAchievementBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AchievementViewHolder(binding)
    }
//        class AchievementViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//            val binding
//            val txtAchievement: TextView = view.findViewById(R.id.txtAchievements)
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
//            val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_achievement, parent, false)
//            return AchievementViewHolder(view)
//        }

        override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
            val achievement = achievements[position]
            val index = position + 1
            holder.binding.txtAchievements.text = "$index . ${achievement.name} (${achievement.year}) - ${achievement.team}"
        }

        override fun getItemCount(): Int {
            return achievements.size
        }

        // Update method to filter data
        fun updateData(newAchievements: List<Achievement>) {
            achievements = newAchievements
            notifyDataSetChanged()
        }
}