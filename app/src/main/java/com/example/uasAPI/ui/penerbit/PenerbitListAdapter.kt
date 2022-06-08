package com.example.uasAPI.ui.penerbit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasAPI.databinding.ListViewTemPenerbitBinding
import com.example.uasAPI.network.Penerbit

class PenerbitListAdapter(private val clickListener: PenerbitListener):
ListAdapter<Penerbit, PenerbitListAdapter.PenerbitViewHolder>(DiffCallback){
    class PenerbitViewHolder(var binding: ListViewTemPenerbitBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(clickListener: PenerbitListener, penerbit: Penerbit){
                    binding.penerbit = penerbit
                    binding.clicklistener = clickListener
                    binding.executePendingBindings()
                }
            }

    companion object DiffCallback: DiffUtil.ItemCallback<Penerbit>() {
        override fun areItemsTheSame(
            oldItem: Penerbit,
            newItem: Penerbit
        ): Boolean {
            return oldItem.penerbit == newItem.penerbit
        }

        override fun areContentsTheSame(
            oldItem: Penerbit,
            newItem: Penerbit
        ): Boolean {
            return oldItem.penerbit == newItem.penerbit
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenerbitViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PenerbitViewHolder(
            ListViewTemPenerbitBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PenerbitViewHolder, position: Int) {
        val penerbit = getItem(position)
        holder.bind(clickListener, penerbit)
    }
}


class PenerbitListener(val clicklistener: (penerbit: Penerbit)-> Unit){
    fun onCLick(penerbit: Penerbit) = clicklistener(penerbit)
}