package com.example.appboer

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JogoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val textViewNome = itemView.findViewById<TextView>(R.id.textViewNome)
    private val textViewDescr = itemView.findViewById<TextView>(R.id.textViewDescr)

    /* Função que recebe uma instância da classe base com as informações preenchidas e mandar pra tela */
    fun bind(item: Jogo){
        textViewNome.text = item.nome
        textViewDescr.text = item.descricao
    }

}