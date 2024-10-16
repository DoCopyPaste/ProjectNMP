package com.ubaya.projectnmp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectnmp.databinding.ActivityOurScheduleBinding
import com.ubaya.projectnmp.databinding.ActivityWhatWePlayBinding
import com.ubaya.projectnmp.databinding.OurScheduleCardBinding
import com.ubaya.projectnmp.databinding.WhatWePlayCardBinding

class OurScheduleAdapter()
    :RecyclerView.Adapter<OurScheduleAdapter.QuestionViewHolder>() {
    class QuestionViewHolder(val binding: OurScheduleCardBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = OurScheduleCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return OurScheduleData.ourScheduleDatas.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) { // set
        val data = OurScheduleData.ourScheduleDatas[position]

        val formattedScheduleDate = OurScheduleData.getFormattedDate(data.schedule)

        // Set data pada elemen UI di dalam card.
        holder.binding.buttonSchedule.text = formattedScheduleDate + "\n" + data.title + "\n" + data.game +" - "+ data.team // Misalnya TextView untuk judul game dengan id txtGameTitle

        // Set onClickListener jika ada event yang ingin di-handle saat card di-klik.
        holder.binding.buttonSchedule.setOnClickListener {
            val intent = Intent(holder.itemView.context, SchedulePageDetailActivity::class.java)
            intent.putExtra("game", data.game)
            intent.putExtra("desc", data.description)
            intent.putExtra("location", data.location)
            intent.putExtra("title", data.title)
            intent.putExtra("team", data.team)
            intent.putExtra("schedule", data.schedule)
            intent.putExtra("image", data.imageId)
            holder.itemView.context.startActivity(intent)
        }
//        holder.binding.buttonSchedule.setOnClickListener {
//            val intent = Intent(this, SchedulePageDetailActivity::class.java)
//            startActivity(intent)
//        }

    }
}

