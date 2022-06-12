package com.example.wasteclassificationapps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteclassificationapps.Organik
import com.example.wasteclassificationapps.R
import com.example.wasteclassificationapps.adapter.ListOrganikAdapter

class OrganikActivity : AppCompatActivity() {

    private lateinit var rvOrganik: RecyclerView
    private val list = ArrayList<Organik>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organik)
        supportActionBar?.hide()

        rvOrganik = findViewById(R.id.rv_organik)
        rvOrganik.setHasFixedSize(true)

        list.addAll(listOrganic)
        showRecyclerList()
    }

    private val listOrganic: ArrayList<Organik>
        get() {
            val organikName = resources.getStringArray(R.array.organik_name)
            val dataPhoto = resources.obtainTypedArray(R.array.data_organik_photo)
            val listOrganik = ArrayList<Organik>()
            for (i in organikName.indices) {
                val organik = Organik(organikName[i], dataPhoto.getResourceId(i, -1))
                listOrganik.add(organik)
            }
            return listOrganik
        }

    private fun showRecyclerList() {
        rvOrganik.layoutManager = LinearLayoutManager(this)
        val listOrganikAdapter = ListOrganikAdapter(list)
        rvOrganik.adapter = listOrganikAdapter
    }
}