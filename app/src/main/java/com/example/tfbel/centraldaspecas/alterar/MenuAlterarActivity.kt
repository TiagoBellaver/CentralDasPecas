package com.example.tfbel.centraldaspecas.alterar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tfbel.centraldaspecas.HomeActivity
import com.example.tfbel.centraldaspecas.R

class MenuAlterarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_alterar)
        supportActionBar?.hide()
    }

    fun alterarcliente(view : View) {
        val intent = Intent(this,
                AlterarClienteActivity::class.java)

        startActivity(intent)
    }

    fun alterarfornecedor(view : View) {
        val intent = Intent(this,
                AlterarFornecedorActivity::class.java)

        startActivity(intent)
    }

    fun alterarproduto(view : View) {
        val intent = Intent(this,
                AlterarProdutoActivity::class.java)

        startActivity(intent)
    }

    fun alterarpedido(view : View) {
        val intent = Intent(this,
                AlterarPedidoActivity::class.java)

        startActivity(intent)
    }

    fun voltar(view : View) {
        val intent = Intent(this,
                HomeActivity::class.java)

        startActivity(intent)
        finish()
    }
}
