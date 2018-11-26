package com.example.tfbel.centraldaspecas.pesquisar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class PesquisarFornecedorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar_fornecedor)
        supportActionBar?.hide()

    }

    fun voltar(view: View){
        val intent = Intent(this,
                MenuPesquisarActivity::class.java)

        startActivity(intent)
        finish()
    }

    fun pesquiser(view: View){
        val intent = Intent(this,
                PesquisarFornecedorTela::class.java)
        intent.putExtra("ID", "campoIDFornecedor")

        startActivity(intent)
        finish()
    }
}
