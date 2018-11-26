package com.example.tfbel.centraldaspecas.pesquisar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class PesquisarProdutosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar_produtos)
        supportActionBar?.hide()

    }

    fun voltar(view: View){
        val intent = Intent(this,
                MenuPesquisarActivity::class.java)

        startActivity(intent)
        finish()
    }

    fun pesquisar(view : View){
        val intent = Intent(this,
                PesquisarProdutoTela::class.java)
        intent.putExtra("ID", findViewById<EditText>(R.id.campoPesquisarProduto).text.toString().toInt())

        startActivity(intent)
        finish()
    }
}
