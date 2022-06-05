package com.example.wasteclassificationapps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteclassificationapps.Anorganik
import com.example.wasteclassificationapps.R
import com.example.wasteclassificationapps.adapter.ListAnorganikAdapter

class AnorganikActivity : AppCompatActivity() {

    private lateinit var rvAnorganik : RecyclerView
    private val list = ArrayList<Anorganik>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anorganik)
        supportActionBar?.hide()

        rvAnorganik = findViewById(R.id.rv_anorganik)
        rvAnorganik.setHasFixedSize(true)

        list.addAll(listInorganic)
        showRecyclerList()
    }

    private val listInorganic: ArrayList<Anorganik>
        get() {
            val anorganikName = resources.getStringArray(R.array.anorganik_name)
            val dataPhoto = resources.obtainTypedArray(R.array.data_anorganik_photo)
            val listAnorganik = ArrayList<Anorganik>()
            for (i in anorganikName.indices) {
                val anorganik = Anorganik(anorganikName[i], dataPhoto.getResourceId(i, -1))
                listAnorganik.add(anorganik)
            }
            return listAnorganik
        }

    private fun showRecyclerList() {
        rvAnorganik.layoutManager = LinearLayoutManager(this)
        val listAnorganikAdapter = ListAnorganikAdapter(list)
        rvAnorganik.adapter = listAnorganikAdapter
    }
}