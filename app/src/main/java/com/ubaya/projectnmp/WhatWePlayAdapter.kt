package com.ubaya.projectnmp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectnmp.databinding.WhatWePlayCardBinding

class WhatWePlayAdapter()
    :RecyclerView.Adapter<WhatWePlayAdapter.QuestionViewHolder>() {
    class QuestionViewHolder(val binding: WhatWePlayCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding =
            WhatWePlayCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return WhatWePlayData.whatWePlayDatas.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val data = WhatWePlayData.whatWePlayDatas[position]

        // Set data pada elemen UI di dalam card.
        holder.binding.eventTitle.text = data.title
        holder.binding.eventDescription.text = data.description

        // Jika gambar ada, tampilkan.
        if (data.imageId != null) {
            holder.binding.eventImage.setImageResource(data.imageId)
        }

        // Set onClickListener untuk mengarahkan ke AchievementsDetail.
        holder.binding.achievementButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, AchievementDetailActivity::class.java)
            intent.putExtra("game_title", data.title)
            intent.putExtra("game_description", data.description)
            holder.itemView.context.startActivity(intent)
        }

//        holder.binding.txtQuestionTitle.text = QuestionData.questions[position].question
//
//        holder.binding.btnEdit.setOnClickListener {
//            val intent = Intent(holder.itemView.context, EditQuestionActivity::class.java)
//            intent.putExtra("question_index", position)
//            holder.itemView.context.startActivity(intent)
//        }

    }

    private fun putExtra(s: String, title: String) {

    }
}

