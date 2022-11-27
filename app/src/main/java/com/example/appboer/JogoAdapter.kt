package com.example.appboer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class JogoAdapter: RecyclerView.Adapter<JogoViewHolder>() {

    private var items = listOf<Jogo>()

    fun updateItems(newItems: List<Jogo>){
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_jogo, parent, false)

        return JogoViewHolder(view)
    }

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int =  items.size



}