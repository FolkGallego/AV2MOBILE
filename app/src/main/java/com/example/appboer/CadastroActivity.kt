package com.example.appboer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.appboer.database.JogoDatabase
import com.example.appboer.database.inserirJogo

class CadastroActivity : AppCompatActivity() {

    private lateinit var editTextNome: EditText
    private lateinit var editTextDescr: EditText
    private lateinit var editTextFabricante: EditText
    private lateinit var editTextTelefone: EditText
    private lateinit var buttonSalvar: Button

    private lateinit var database: JogoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        editTextNome = findViewById(R.id.editTextNome)
        editTextDescr = findViewById(R.id.editTextDescr)
        editTextFabricante = findViewById(R.id.editTextFabricante)
        editTextTelefone = findViewById(R.id.editTextTelefone)
        buttonSalvar = findViewById(R.id.buttonSalvar)

        database = JogoDatabase(this)

        buttonSalvar.setOnClickListener(){
        salvarJogo()
        }
    }

    private fun salvarJogo() {
        val jogo = Jogo(
            nome = editTextNome.text.toString(),
            descricao = editTextDescr.text.toString(),
            fabricante = editTextFabricante.text.toString(),
            telefone = editTextTelefone.text.toString()
        )

       val idJogo = database.inserirJogo(jogo)

        if(idJogo == -1L){
            Toast.makeText(this, "Erro ao inserir", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Contato inserido com sucesso id: $idJogo", Toast.LENGTH_SHORT).show()
            editTextNome.text.clear()
            editTextDescr.text.clear()
            editTextFabricante.text.clear()
            editTextTelefone.text.clear()
        }


    }

}