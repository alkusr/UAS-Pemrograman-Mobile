package com.example.uasAPI.ui.gunung

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasAPI.databinding.ListViewTemGunungBinding
import com.example.uasAPI.network.Gunung

class GunungListAdapter(private val clickListener: GunungListener):
ListAdapter<Gunung, GunungListAdapter.GunungViewHolder>(DiffCallback){
    class GunungViewHolder(var binding: ListViewTemGunungBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(clickListener: GunungListener, gunung: Gunung){
                    binding.gunung = gunung
                    binding.clicklistener = clickListener
                    binding.executePendingBindings()
                }
            }

    companion object DiffCallback: DiffUtil.ItemCallback<Gunung>() {
        override fun areItemsTheSame(
            oldItem: Gunung,
            newItem: Gunung
        ): Boolean {
            return oldItem.nama == newItem.nama
        }

        override fun areContentsTheSame(
            oldItem: Gunung,
            newItem: Gunung
        ): Boolean {
            return oldItem.nama == newItem.nama
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GunungViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GunungViewHolder(
            ListViewTemGunungBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GunungViewHolder, position: Int) {
        val gunung = getItem(position)
        holder.bind(clickListener, gunung)
    }
}


class GunungListener(val clicklistener: (gunung: Gunung)-> Unit){
    fun onCLick(gunung: Gunung) = clicklistener(gunung)
}