package com.ubaya.projectnmp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectnmp.databinding.ActivityOurScheduleBinding
import com.ubaya.projectnmp.databinding.ActivityWhatWePlayBinding

public class WhatWePlayAdapter() : RecyclerView.Adapter<WhatWePlayAdapter.WhatWePlayViewHolder>(){
    class WhatWePlayViewHolder(val binding:
                        ActivityWhatWePlayBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WhatWePlayViewHolder {
        TODO("Not yet implemented")
        val binding = ActivityOurScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //return WhatWePlayViewHolder(binding.root);
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: WhatWePlayViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}