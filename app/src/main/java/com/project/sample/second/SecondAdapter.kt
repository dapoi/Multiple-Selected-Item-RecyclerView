package com.project.sample.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.sample.R
import com.project.sample.databinding.ItemListPeopleBinding
import com.project.sample.model.People

class SecondAdapter : RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {

    private var listPeople = ArrayList<People>()

    fun setListPeople(toList: List<People>) {
        listPeople.clear()
        listPeople.addAll(toList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        return SecondViewHolder(
            ItemListPeopleBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_list_people,
                    parent,
                    false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.bind(listPeople[position])
    }

    override fun getItemCount(): Int = listPeople.size

    class SecondViewHolder(private val binding: ItemListPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: People) {
            with(binding) {
                name.text = item.name
                age.text = item.age.toString()
            }
        }
    }
}