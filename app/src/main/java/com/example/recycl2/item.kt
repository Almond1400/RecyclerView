package com.example.recycl2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class item : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val getData = intent.getParcelableExtra<DataClass>("android")
        if (getData != null){
            val Book: TextView = findViewById(R.id.nameBook)
            val Author: TextView = findViewById(R.id.Authorname)
            val Genre: TextView = findViewById(R.id.genre)

            Book.text = getData.heading
            Author.text = getData.auttxt
            Genre.text = getData.genretxt
        }
    }
}