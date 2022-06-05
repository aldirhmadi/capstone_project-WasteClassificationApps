package com.example.wasteclassificationapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteclassificationapps.Organik
import com.example.wasteclassificationapps.R

class ListOrganikAdapter(private val listOrganik: ArrayList<Organik>) : RecyclerView.Adapter<ListOrganikAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_organik, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo) = listOrganik[position]
        holder.imgOrganikPhoto.setImageResource(photo)
        holder.tvOrganikName.text = name
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Sampah Organik || " + listOrganik[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listOrganik.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgOrganikPhoto: ImageView = itemView.findViewById(R.id.img_item_organik_photo)
        var tvOrganikName: TextView = itemView.findViewById(R.id.tv_organik_name)

    }

}