package com.example.tfbel.centraldaspecas.excluir

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.tfbel.centraldaspecas.R

class ExcluirProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excluir_produto)
        supportActionBar?.hide()

    }

    fun voltar(view: View){
        val intent = Intent(this,
                MenuExcluirActivity::class.java)

        startActivity(intent)
    }
}
