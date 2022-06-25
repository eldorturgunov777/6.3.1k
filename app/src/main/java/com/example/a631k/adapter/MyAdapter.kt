package com.example.a631k.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a631k.R
import com.example.a631k.data.User


/**
 * Created by Eldor Turgunov on 25.06.2022.
 * 6.3.1k
 * eldorturgunov777@gmail.com
 */
class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var items = emptyList<User>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        holder.title.text = data.title
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(user: List<User>) {
        this.items = user
        notifyDataSetChanged()
    }
}