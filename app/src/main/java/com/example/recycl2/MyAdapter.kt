package com.example.recycl2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter (private val newList : ArrayList<DataClass>): RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    var onItemClick: ((DataClass) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item,
                parent,false)
        return MyViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curentItem = newList[position]
        holder.ImageView.setImageResource(curentItem.titleImage)
        holder.txtHead.text = curentItem.heading
        holder.txtBonk.text = curentItem.auttxt

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(curentItem)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ImageView : ShapeableImageView =
            itemView.findViewById(R.id.imageItem)
        val txtHead : TextView = itemView.findViewById(R.id.txtItem)
        val txtBonk : TextView = itemView.findViewById(R.id.txtAut)
    }
}