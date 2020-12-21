package com.codepalace.expandfab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepalace.expandfab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var textList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        addToList()
        setUpRecyclerView()
        setUpFab()

    }

    private fun setUpFab() {
        val fab = binding.fab

        fab.setOnClickListener {
            Toast.makeText(applicationContext, "New chat clicked*", Toast.LENGTH_SHORT).show()
        }

        binding.rvRecycler.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    fab.collapse()
                } else {
                    fab.expand()
                }
            }
        })
    }

    private fun setUpRecyclerView() {

        binding.rvRecycler.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvRecycler.adapter = RecyclerAdapter(textList)
    }

    private fun addToList() {

        for (i in 0..100) {
            textList.add("Sample text $i")
        }
    }
}


