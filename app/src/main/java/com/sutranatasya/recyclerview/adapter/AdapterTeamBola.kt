package com.sutranatasya.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sutranatasya.recyclerview.databinding.ListItemPemainBinding
import com.sutranatasya.recyclerview.model.Pemain

class AdapterTeamBola(
    private val data: List<Pemain>,
    private val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterTeamBola.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemPemainBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.foto.setImageResource(item.foto)
        holder.nama.text = item.nama

        holder.itemView.setOnClickListener {
            itemClick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(binding: ListItemPemainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val foto = binding.image
        val nama = binding.txtnama
    }

    interface OnClickListener {
        fun detailData(item: Pemain)
    }
}
