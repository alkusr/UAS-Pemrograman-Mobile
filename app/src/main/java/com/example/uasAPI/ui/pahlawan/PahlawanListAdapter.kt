package com.example.uasAPI.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasAPI.databinding.ListViewItemPahlawanBinding
import com.example.uasAPI.network.Pahlawan

class PahlawanListAdapter(private val clickListener: PahlawanListener) :
    ListAdapter<Pahlawan, PahlawanListAdapter.PahlawanViewHolder>(DiffCallback) {
    class PahlawanViewHolder(var binding: ListViewItemPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: PahlawanListener, pahlawan: Pahlawan) {
            binding.pahlawan = pahlawan
            binding.clicklistener = clickListener
            binding.executePendingBindings()
        }
    }

    //disini changes
    companion object DiffCallback: DiffUtil.ItemCallback<Pahlawan>() {
        override fun areItemsTheSame(
            oldItem: Pahlawan,
            newItem: Pahlawan
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: Pahlawan,
            newItem: Pahlawan
        ): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PahlawanViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PahlawanViewHolder(
            ListViewItemPahlawanBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PahlawanViewHolder, position: Int) {
        val doa = getItem(position)
        holder.bind(clickListener, doa)
    }
}

class PahlawanListener(val clickListener: (doa: Pahlawan) -> Unit) {
    fun onClick(doa: Pahlawan) = clickListener(doa)
}