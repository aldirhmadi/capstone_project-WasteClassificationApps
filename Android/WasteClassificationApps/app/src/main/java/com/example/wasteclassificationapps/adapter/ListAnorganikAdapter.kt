package com.example.wasteclassificationapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteclassificationapps.Anorganik
import com.example.wasteclassificationapps.R

class ListAnorganikAdapter(private val listAnorganik: ArrayList<Anorganik>): RecyclerView.Adapter<ListAnorganikAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_anorganik, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo) = listAnorganik[position]
        holder.imgAnorganikPhoto.setImageResource(photo)
        holder.tvAnorganikName.text = name
    }

    override fun getItemCount(): Int = listAnorganik.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAnorganikPhoto : ImageView = itemView.findViewById(R.id.img_item_anorganik_photo)
        var tvAnorganikName : TextView = itemView.findViewById(R.id.tv_anorganik_name)
    }
}