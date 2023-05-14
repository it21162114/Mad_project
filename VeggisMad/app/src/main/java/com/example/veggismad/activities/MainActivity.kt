package com.example.veggismad.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.veggismad.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnInsertHome: Button
    private lateinit var deliveryListButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_main)

        btnInsertHome = findViewById(R.id.button1)
        deliveryListButton = findViewById(R.id.buttonList)

        btnInsertHome.setOnClickListener {
            val intent = Intent(this, Insert::class.java)
            startActivity(intent)
        }

        deliveryListButton.setOnClickListener{
            val intent = Intent(this, Read::class.java)
            startActivity(intent)
        }


    }
}