package com.project.sample.first

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.sample.R
import com.project.sample.databinding.ItemListPeopleBinding
import com.project.sample.model.People

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var listPeople = ArrayList<People>()
    private val selectedItem = HashSet<Int>()

    fun setListPeople(peoples: List<People>) {
        listPeople.clear()
        listPeople.addAll(peoples)
        notifyDataSetChanged()
    }

    fun getSelectedItemList(): List<People> {
        val selectedList = mutableListOf<People>()
        for (i in selectedItem) {
            selectedList.add(listPeople[i])
        }
        return selectedList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemListPeopleBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_list_people,
                    parent,
                    false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = listPeople[position]

        holder.apply {
            name.text = item.name
            age.text = item.age.toString()

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

    override fun getItemCount(): Int = listPeople.size

    class MainViewHolder(binding: ItemListPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var name = binding.name
        var age = binding.age
    }
}