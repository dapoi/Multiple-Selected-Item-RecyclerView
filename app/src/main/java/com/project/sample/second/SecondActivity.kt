package com.project.sample.second

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.sample.databinding.ActivitySecondBinding

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

        val intent = intent.getStringArrayExtra(EXTRA_SELECTED_NAME)
        binding.recyclerView.apply {
            adapter = secondAdapter
            layoutManager = LinearLayoutManager(this@SecondActivity)
            setHasFixedSize(true)
            intent?.let { secondAdapter.setListName(it.toList()) }
        }
    }

    companion object {
        const val EXTRA_SELECTED_NAME = "extra_selected_name"
    }
}