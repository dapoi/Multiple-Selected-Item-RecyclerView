package com.project.sample.second

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.sample.databinding.ActivitySecondBinding
import com.project.sample.model.People

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy(LazyThreadSafetyMode.NONE) {
        ActivitySecondBinding.inflate(
            layoutInflater
        )
    }

    private val secondAdapter = SecondAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = intent.getParcelableArrayExtra(EXTRA_SELECTED)
        binding.recyclerView.apply {
            adapter = secondAdapter
            layoutManager = LinearLayoutManager(this@SecondActivity)
            setHasFixedSize(true)
            data?.let {
                secondAdapter.setListPeople(it.toList() as List<People>)
            }
        }
    }

    companion object {
        const val EXTRA_SELECTED = "extra_selected_data"
    }
}