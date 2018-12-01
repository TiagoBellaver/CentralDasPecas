package com.example.tfbel.centraldaspecas.pesquisar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tfbel.centraldaspecas.HomeActivity
import com.example.tfbel.centraldaspecas.R

class MenuPesquisarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_pesquisar)
        supportActionBar?.hide()
    }

    fun pesquisarcliente(view: View){
        val intent = Intent(this,
                PesquisarClienteActivity::class.java)

        startActivity(intent)
    }

    fun pesquisarfornecedor(view: View){
        val intent = Intent(this,
                PesquisarFornecedorActivity::class.java)

        startActivity(intent)
    }

    fun pesquisarproduto(view: View){
        val intent = Intent(this,
                PesquisarProdutosActivity::class.java)

        startActivity(intent)
    }

    fun pesquisarpedido(view: View){
        val intent = Intent(this,
                PesquisarPedidoActivity::class.java)

        startActivity(intent)
    }

    fun voltar(view : View) {
        val intent = Intent(this,
                HomeActivity::class.java)

        startActivity(intent)
        finish()
    }
}
