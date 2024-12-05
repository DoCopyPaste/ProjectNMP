package com.ubaya.projectnmp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.projectnmp.databinding.ItemProposalBinding

data class Proposal(val game: String, val status: String)

class ProposalAdapter(private val proposals: List<Proposal>) :
    RecyclerView.Adapter<ProposalAdapter.ProposalViewHolder>() {

    inner class ProposalViewHolder(val binding: ItemProposalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProposalViewHolder {
        val binding = ItemProposalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProposalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProposalViewHolder, position: Int) {
        val proposal = proposals[position]
        holder.binding.gameText.text = proposal.game
        holder.binding.statusText.text = proposal.status
    }

    override fun getItemCount(): Int = proposals.size
}