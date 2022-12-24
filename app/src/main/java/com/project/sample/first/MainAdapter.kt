package com.project.sample.first

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.sample.R
import com.project.sample.databinding.ItemListNameBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var listName = listOf<String>()
    private val selectedItem = HashSet<Int>()

    fun setListName(listName: List<String>) {
        this.listName = listName
        notifyDataSetChanged()
    }

    fun getSelectedItemList(): List<String> {
        val selectedList = mutableListOf<String>()
        for (i in selectedItem) {
            selectedList.add(listName[i])
        }
        return selectedList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemListNameBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_list_name,
                    parent,
                    false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = listName[position]

        holder.apply {
            name.text = item

            itemView.isActivated = selectedItem.contains(position)
            itemView.setOnClickListener {
                if (itemView.isActivated) {
                    selectedItem.remove(position)
                    itemView.setBackgroundColor(Color.WHITE)
                    name.setTextColor(Color.BLACK)
                    itemView.isActivated = false
                } else {
                    selectedItem.add(position)
                    itemView.setBackgroundColor(Color.GRAY)
                    name.setTextColor(Color.WHITE)
                    itemView.isActivated = true
                }
            }

        }
    }

    override fun getItemCount(): Int = listName.size

    class MainViewHolder(binding: ItemListNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var name = binding.name
    }
}