package com.example.veggismad.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.veggismad.R

class Read : AppCompatActivity() {

    private lateinit var deliveryRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        deliveryRecyclerView = findViewById(R.id.listView)
        deliveryRecyclerView.layoutManager = LinearLayoutManager(this)
        deliveryRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

    }
}