package com.example.wasteclassificationapps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteclassificationapps.B3
import com.example.wasteclassificationapps.R
import com.example.wasteclassificationapps.adapter.ListB3Adapter

class B3Activity : AppCompatActivity() {

    private lateinit var rvB3: RecyclerView
    private val list = ArrayList<B3>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b3)
        supportActionBar?.hide()

        rvB3 = findViewById(R.id.rv_b3)
        rvB3.setHasFixedSize(true)

        list.addAll(listHazardous)
        showRecyclerList()
    }

    private val listHazardous: ArrayList<B3>
        get() {
            val b3Name = resources.getStringArray(R.array.b3_name)
            val dataPhoto = resources.obtainTypedArray(R.array.data_b3_photo)
            val listB3 = ArrayList<B3>()
            for (i in b3Name.indices) {
                val b3 = B3(b3Name[i], dataPhoto.getResourceId(i, -1))
                listB3.add(b3)
            }
            return listB3
        }

    private fun showRecyclerList() {
        rvB3.layoutManager = LinearLayoutManager(this)
        val listB3Adapter = ListB3Adapter(list)
        rvB3.adapter = listB3Adapter
    }
}