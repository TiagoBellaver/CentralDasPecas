package com.example.tfbel.centraldaspecas.pesquisar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class PesquisarPedidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar_pedido)
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
                PesquisarPedidoTela::class.java)
        intent.putExtra("ID", findViewById<EditText>(R.id.campoPesquisarPedido).text.toString().toInt())

        startActivity(intent)
        finish()
    }
}
