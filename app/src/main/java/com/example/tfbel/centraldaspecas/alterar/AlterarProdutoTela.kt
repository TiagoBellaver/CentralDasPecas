package com.example.tfbel.centraldaspecas.alterar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R
import com.example.tfbel.centraldaspecas.cadastrar.MenuCadastrarActivity

class AlterarProdutoTela : AppCompatActivity() {

    var global = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar_produto_tela)
        supportActionBar?.hide()

        val intent = getIntent()
        val ID = intent.getIntExtra("ID", 0)
        global = ID
        var bancoproduto = openOrCreateDatabase("ProdutoDB", Context.MODE_PRIVATE, null)

        val auxiliar = bancoproduto.rawQuery("""SELECT *FROM ProdutoDB WHERE campoIDPRoduto = $ID""", null)

        if(auxiliar.moveToNext()){
            findViewById<EditText>(R.id.campoIDProduto).text.append(auxiliar.getInt(0).toString())
            findViewById<EditText>(R.id.campoDescricaoProduto).text.append(auxiliar.getString(1))
            findViewById<EditText>(R.id.campoQuantidadeProduto).text.append(auxiliar.getInt(2).toString())
            findViewById<EditText>(R.id.campoPrecoCompra).text.append(auxiliar.getString(3))
            findViewById<EditText>(R.id.campoPrecoVenda).text.append(auxiliar.getString(4))
        }
        bancoproduto.close()
    }

    fun alterar(botao: View){
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

        bancoproduto.execSQL("""UPDATE ProdutoDB
            SET campoDescricaoProduto = '$DescricaoProduto',
            campoQuantidadeProduto = '$QuantidadeProduto',
            campoPrecoCompra = '$PrecoCompra',
            campoPrecoVenda = '$PrecoVenda'

            WHERE campoIDProduto = '$global'

             """)

        bancoproduto.close()
        finish()
    }

    fun cancelar(view : View){
        val intent = Intent(this,
                AlterarProdutoActivity::class.java)

        startActivity(intent)
    }
}
