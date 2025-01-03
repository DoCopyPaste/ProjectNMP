package com.ubaya.projectnmp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ubaya.projectnmp.databinding.WhatWePlayCardBinding

class WhatWePlayAdapter(private var games: List<Game>)
    :RecyclerView.Adapter<WhatWePlayAdapter.QuestionViewHolder>() {
    class QuestionViewHolder(val binding: WhatWePlayCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding =
            WhatWePlayCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val data = games[position]

        // Set data pada elemen UI di dalam card.
        holder.binding.eventTitle.text = data.name
        holder.binding.eventDescription.text = data.description

        // Jika gambar ada, tampilkan.
        if (data.idGame != null) {
            val imageView = holder.binding.eventImage
            Picasso.get()
                .load("file:///android_asset/games/${data.idGame}.png")
                .into(imageView)
        }

        // Set onClickListener untuk mengarahkan ke AchievementsDetail.
        holder.binding.achievementButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, AchievementDetailActivity::class.java)
            intent.putExtra("id", data.idGame)
            intent.putExtra("title", data.name)
            intent.putExtra("description", data.description)
            intent.putExtra("image", data.idGame)
            holder.itemView.context.startActivity(intent)
        }

        holder.binding.teamButton.setOnClickListener{
            val intent = Intent(holder.itemView.context, TeamActivity::class.java)
            intent.putExtra("id", data.idGame)
            intent.putExtra("title", data.name)
            intent.putExtra("description", data.description)
            intent.putExtra("image", data.idGame)
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

