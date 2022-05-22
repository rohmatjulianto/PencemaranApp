package com.wiji.pencemaranapp.option

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wiji.pencemaranapp.databinding.ItemOptionBinding

class OptionAdapter(val listener : OptionClickListener, val items: ArrayList<String>) :
    RecyclerView.Adapter<OptionAdapter.viewHolder>() {

    class viewHolder(val binding: ItemOptionBinding): RecyclerView.ViewHolder(binding.root) {
        fun onbind(item: String) {
            binding.tvTitle.text = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = ItemOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.onbind(items.get(position))
        holder.binding.root.setOnClickListener{
            listener.onClick(items.get(position))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}