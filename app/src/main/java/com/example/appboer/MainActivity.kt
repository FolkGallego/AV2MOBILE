package com.example.appboer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appboer.database.JogoDatabase
import com.example.appboer.database.selecionarJogo

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val jogoAdapter = JogoAdapter()
    private lateinit var database: JogoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView  = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = jogoAdapter

        database = JogoDatabase(this)
    }

    override fun onResume() {
        super.onResume()

        val jogo = database.selecionarJogo()
        jogoAdapter.updateItems(jogo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_cadastrar -> {
                val intent = Intent(this, CadastroActivity::class.java)
                startActivity(intent)
                true
            }
            else -> {
                false
            }
        }
    }

}