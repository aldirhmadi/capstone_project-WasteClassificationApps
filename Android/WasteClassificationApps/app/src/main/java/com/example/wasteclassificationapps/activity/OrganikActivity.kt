package com.example.wasteclassificationapps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteclassificationapps.Organik
import com.example.wasteclassificationapps.R
import com.example.wasteclassificationapps.adapter.ListOrganikAdapter
import com.example.wasteclassificationapps.databinding.ActivityOrganikBinding

class OrganikActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrganikBinding
    private lateinit var rvOrganik: RecyclerView
    private val list = ArrayList<Organik>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrganikBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        rvOrganik = findViewById(R.id.rv_organik)
        rvOrganik.setHasFixedSize(true)

        list.addAll(listOrganic)
        showRecyclerList()

        val organik = arrayOf("Sampah sisa makanan", "Sampah sisa sayur", "Sampah kotoran hewan", "Sampah kulit biji-bijian", "Sampah daun-daun kering", "Sampah sisa kayu", "Sampah kertas")

        val organikAdapter : ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,
            organik
        )

        binding.rvOrganik.adapter

        binding.btnSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.btnSearch.clearFocus()
                if (organik.contains(query)) {

                    organikAdapter.filter.filter(query)

                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                organikAdapter.filter.filter(newText)
                return false
            }

        })

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