package com.example.appboer.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class JogoDatabase(
    context: Context
) : SQLiteOpenHelper(context, "jogo.db", null, 1) {


    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """
            Create Table TB_JOGO(
                    ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    NOME TEXT, 
                    DESCRICAO TEXT,
                    FABRICANTE TEXT,
                    TELEFONE TEXT
            );
        """.trimIndent()

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS TB_JOGO")
        onCreate(db)
    }


}