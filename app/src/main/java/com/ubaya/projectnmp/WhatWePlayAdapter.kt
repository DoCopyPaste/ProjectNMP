package com.ubaya.projectnmp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectnmp.databinding.ActivityOurScheduleBinding
import com.ubaya.projectnmp.databinding.ActivityWhatWePlayBinding
import com.ubaya.projectnmp.databinding.WhatWePlayCardBinding

class WhatWePlayAdapter()
    :RecyclerView.Adapter<WhatWePlayAdapter.QuestionViewHolder>() {
    class QuestionViewHolder(val binding: WhatWePlayCardBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = WhatWePlayCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return WhatWePlayData.whatWePlayDatas.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) { // set
        val data = WhatWePlayData.whatWePlayDatas[position]

        // Set data pada elemen UI di dalam card.
        holder.binding.eventTitle.text = data.title // Misalnya TextView untuk judul game dengan id txtGameTitle
        holder.binding.eventDescription.text = data.description // TextView untuk deskripsi game dengan id txtGameDescription

        // Jika gambar ada, tampilkan.
        if (data.imageId != null) {
            holder.binding.eventImage.setImageResource(data.imageId) // Misalnya ImageView untuk gambar game dengan id imgGame
        }

        // Set onClickListener jika ada event yang ingin di-handle saat card di-klik.
        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.itemView.context, WhatWePlayActivity::class.java)
            intent.putExtra("game_title", data.title)
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
}

