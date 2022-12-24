package com.project.sample.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.sample.R
import com.project.sample.databinding.ItemListNameBinding

class SecondAdapter : RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {

    private var listName = listOf<String>()

    fun setListName(toList: List<String>) {
        listName = toList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        return SecondViewHolder(
            ItemListNameBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_list_name,
                    parent,
                    false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.bind(listName[position])
    }

    override fun getItemCount(): Int = listName.size

    class SecondViewHolder(private val binding: ItemListNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.name.text = item
        }
    }
}