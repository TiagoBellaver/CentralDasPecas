package com.example.tfbel.centraldaspecas.cadastrar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class CadastrarProdutosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_produtos)
        supportActionBar?.hide()

        var bancoproduto = openOrCreateDatabase("ProdutoDB", Context.MODE_PRIVATE,null)

        bancoproduto.execSQL("""CREATE TABLE IF NOT EXISTS ProdutoDB(

            campoIDProduto INTEGER PRIMARY KEY AUTOINCREMENT,
            campoDescricaoProduto VARCHAR(256),
            campoQuantidadeProduto INTEGER,
            campoPrecoCompra VARCHAR(50),
            campoPrecoVenda VARCHAR(50));
            """)

        bancoproduto.close()
    }

    fun cadastrar(botao: View){
        var campoIDProduto = findViewById<EditText>(R.id.campoIDProduto)
        var campoDescricaoProduto = findViewById<EditText>(R.id.campoDescricaoProduto)
        var campoQuantidadeProduto = findViewById<EditText>(R.id.campoQuantidadeProduto)
        var campoPrecoCompra = findViewById<EditText>(R.id.campoPrecoCompra)
        var campoPrecoVenda = findViewById<EditText>(R.id.campoPrecoVenda)

        val DescricaoProduto = campoDescricaoProduto.text.toString()
        val QuantidadeProduto = campoQuantidadeProduto.text.toString().toInt()
        val PrecoCompra = campoPrecoCompra.text.toString()
        val PrecoVenda = campoPrecoVenda.text.toString()

        var bancoproduto = openOrCreateDatabase("ProdutoDB", Context.MODE_PRIVATE,null)

        bancoproduto.execSQL("""INSERT INTO ProdutoDB('campoDescricaoProduto', 'campoQuantidadeProduto',
            'campoPrecoCompra', 'campoPrecoVenda')
            VALUES('$DescricaoProduto', '$QuantidadeProduto', '$PrecoCompra', '$PrecoVenda')""")

        bancoproduto.close()
        finish()
    }

    fun cancelar(view : View){
        val intent = Intent(this,
                MenuCadastrarActivity::class.java)

        startActivity(intent)
    }
}
