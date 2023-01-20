package com.project.sample.first

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.sample.databinding.ActivityMainBinding
import com.project.sample.model.People
import com.project.sample.second.SecondActivity

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(
            layoutInflater
        )
    }
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mainAdapter = MainAdapter()
        mainAdapter.setListPeople(PeopleData.listPeople)
        binding.apply {
            recyclerView.adapter = mainAdapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.setHasFixedSize(true)
        }

        binding.button.setOnClickListener {
            val selectedList = mainAdapter.getSelectedItemList()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.EXTRA_SELECTED, selectedList.toTypedArray())
            startActivity(intent)
        }
    }

    object PeopleData {
        val listPeople = listOf(
            People("A", 15),
            People("B", 16),
            People("C", 17),
            People("D", 18),
            People("E", 19),
        )
    }
}