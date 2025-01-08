package com.ubaya.projectnmp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectnmp.databinding.ActivityOurScheduleBinding
import com.ubaya.projectnmp.databinding.ActivityWhatWePlayBinding
import com.ubaya.projectnmp.databinding.OurScheduleCardBinding
import com.ubaya.projectnmp.databinding.WhatWePlayCardBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class OurScheduleAdapter(private var events: List<Event>)
    :RecyclerView.Adapter<OurScheduleAdapter.QuestionViewHolder>() {
    class QuestionViewHolder(val binding: OurScheduleCardBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = OurScheduleCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) { // set
        val data = events[position]

        val formattedScheduleDate = getFormattedDate(data.schedule)

        // Set data pada elemen UI di dalam card.
        holder.binding.buttonSchedule.text = formattedScheduleDate + "\n" + data.title + "\n" + data.game +" - "+ data.team // Misalnya TextView untuk judul game dengan id txtGameTitle

        // Set onClickListener jika ada event yang ingin di-handle saat card di-klik.
        holder.binding.buttonSchedule.setOnClickListener {
            val intent = Intent(holder.itemView.context, SchedulePageDetailActivity::class.java)
            intent.putExtra("game", data.game)
            intent.putExtra("description", data.description)
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

    // Fungsi untuk memformat Date ke format yang diinginkan (contoh: "05 SEP")
    fun getFormattedDate(date: Date): String {
        //val targetFormat = SimpleDateFormat("dd MMMM yyyy", Locale.US)
        val targetFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)
        val formattedDate = targetFormat.format(date)
        return formattedDate.substring(0, 6).uppercase()
    }

    // Fungsi untuk mengambil jam dalam format "hh:mm a" (12-hour format dengan AM/PM)
    fun getFormattedTime(date: Date): String {
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.US)  // Format jam 12 dengan AM/PM
        return timeFormat.format(date)
    }
}

