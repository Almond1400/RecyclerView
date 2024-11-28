package com.example.recycl2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var newRecycleView : RecyclerView
    private lateinit var newArrayList : ArrayList<DataClass>
    private lateinit var imageid : Array<Int>
    private lateinit var textId : Array<String>
    private lateinit var textAutId : Array<String>
    private lateinit var genreid: Array<String>
    private lateinit var MyAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageid = arrayOf(
            R.drawable.book,
            R.drawable.book,
            R.drawable.book,
            R.drawable.book,
            R.drawable.book,
            R.drawable.book,
            R.drawable.book,
            R.drawable.book,
            R.drawable.book,
            R.drawable.book
        )

        textId = resources.getStringArray(R.array.book)
        textAutId = resources.getStringArray(R.array.author)
        genreid = resources.getStringArray(R.array.genre)
        newRecycleView = findViewById(R.id.recycleView)
        newRecycleView.layoutManager = LinearLayoutManager(this)
        newRecycleView.setHasFixedSize(true)
        newArrayList = arrayListOf<DataClass>()
        getUserdata()

        MyAdapter = MyAdapter(newArrayList)
        newRecycleView.adapter = MyAdapter

        MyAdapter.onItemClick = {
            val intent = Intent( this, item::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }
    private fun getUserdata() {
        for (i in imageid.indices)
        {
            val data = DataClass(imageid[i],textId[i],textAutId[i], genreid[i])
            newArrayList.add(data)
        }
        newRecycleView.adapter = MyAdapter(newArrayList)
    }
}