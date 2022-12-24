package com.project.sample.first

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.sample.databinding.ActivityMainBinding
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
        mainAdapter.setListName(generateRandomName())
        binding.apply {
            recyclerView.adapter = mainAdapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.setHasFixedSize(true)
        }

        binding.button.setOnClickListener {
            val selectedList = mainAdapter.getSelectedItemList()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.EXTRA_SELECTED_NAME, selectedList.toTypedArray())
            startActivity(intent)
        }
    }

    private fun generateRandomName(): List<String> {
        val listName = listOf(
            "Ade",
            "Adi",
            "Adit",
            "Aditya",
            "Aditya Pratama",
            "Aditya Pratama Putra",
        )
        return listName.shuffled()
    }
}