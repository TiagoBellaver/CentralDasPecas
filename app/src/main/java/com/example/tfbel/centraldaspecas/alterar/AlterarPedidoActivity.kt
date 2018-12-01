package com.example.tfbel.centraldaspecas.alterar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.HomeActivity
import com.example.tfbel.centraldaspecas.R

class AlterarPedidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar_pedido)
        supportActionBar?.hide()
    }

    fun alterar(view : View){
        val intent = Intent(this,
                AlterarClienteTela::class.java)
        intent.putExtra("ID", findViewById<EditText>(R.id.campoAlterarPedido).text.toString().toInt())

        startActivity(intent)
        finish()
    }

    fun voltar(view : View) {
        val intent = Intent(this,
                MenuAlterarActivity::class.java)

        startActivity(intent)
        finish()
    }
}
