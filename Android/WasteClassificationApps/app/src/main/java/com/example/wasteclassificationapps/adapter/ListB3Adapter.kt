package com.example.wasteclassificationapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wasteclassificationapps.B3
import com.example.wasteclassificationapps.R

class ListB3Adapter(private val listB3: ArrayList<B3>) : RecyclerView.Adapter<ListB3Adapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_b3, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo) = listB3[position]
        holder.imgB3Photo.setImageResource(photo)
        holder.tvB3Name.text = name
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Sampah B3 || " + listB3[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listB3.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgB3Photo : ImageView = itemView.findViewById(R.id.img_item_b3_photo)
        var tvB3Name : TextView = itemView.findViewById(R.id.tv_b3_name)
    }

}