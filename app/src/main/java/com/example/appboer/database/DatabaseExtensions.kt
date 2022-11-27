package com.example.appboer.database

import android.annotation.SuppressLint
import android.content.ContentValues
import com.example.appboer.Jogo

fun JogoDatabase.inserirJogo(item: Jogo): Long {

   val idJogo =  writableDatabase.insert("TB_JOGO", null, ContentValues().apply {
        put("NOME", item.nome)
        put("DESCRICAO", item.descricao)
        put("FABRICANTE", item.fabricante)
        put("TELEFONE", item.telefone)
    })

    return idJogo
}

@SuppressLint("Range")
fun JogoDatabase.selecionarJogo() : List<Jogo>{
    val sql = "SELECT * FROM TB_JOGO"
    val cursor = readableDatabase.rawQuery(sql, null)
    val jogoList = mutableListOf<Jogo>()


    if(cursor.count > 0) {
        while(cursor.moveToNext()){

            val jogo = Jogo(
                id = cursor.getInt(cursor.getColumnIndex("ID")),
                nome = cursor.getString(cursor.getColumnIndex("NOME")),
                descricao = cursor.getString(cursor.getColumnIndex("DESCRICAO")),
                fabricante = cursor.getString(cursor.getColumnIndex("FABRICANTE")),
                telefone = cursor.getString(cursor.getColumnIndex("TELEFONE"))
                )
            jogoList.add(jogo)
        }
        cursor.close()
    }
    return jogoList
}
