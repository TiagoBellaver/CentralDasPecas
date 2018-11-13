package com.example.tfbel.centraldaspecas.excluir

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tfbel.centraldaspecas.HomeActivity
import com.example.tfbel.centraldaspecas.R

class MenuExcluirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_excluir)
        supportActionBar?.hide()

    }

    fun voltar(view : View) {
        val intent = Intent(this,
                HomeActivity::class.java)

        startActivity(intent)
        finish()
    }

    fun excluircliente(view : View) {
        val intent = Intent(this,
                ExcluirClienteActivity::class.java)

        startActivity(intent)
    }

    fun excluirfornecedor(view : View) {
        val intent = Intent(this,
                ExcluirFornecedorActivity::class.java)

        startActivity(intent)
    }

    fun excluirproduto(view: View){
        val intent = Intent(this,
                ExcluirProdutoActivity::class.java)

        startActivity(intent)
    }

    fun excluirpedido(view: View){
        val intent = Intent(this,
                ExcluirPedidoActivity::class.java)

        startActivity(intent)
    }
}
