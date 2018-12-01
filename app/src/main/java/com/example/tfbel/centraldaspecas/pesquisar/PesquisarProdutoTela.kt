package com.example.tfbel.centraldaspecas.pesquisar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class PesquisarProdutoTela : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar_produto_tela)
        supportActionBar?.hide()

        val intent = getIntent()
        val ID = intent.getIntExtra("ID", 0)
        var bancoproduto = openOrCreateDatabase("ProdutoDB", Context.MODE_PRIVATE, null)

        val auxiliar = bancoproduto.rawQuery("""SELECT *FROM ProdutoDB WHERE campoIDProduto = $ID""", null)

        if(auxiliar.moveToNext()){
            findViewById<EditText>(R.id.campoIDProduto).text.append(auxiliar.getInt(0).toString())
            findViewById<EditText>(R.id.campoDescricaoProduto).text.append(auxiliar.getString(1))
            findViewById<EditText>(R.id.campoQuantidadeProduto).text.append(auxiliar.getInt(2).toString())
            findViewById<EditText>(R.id.campoPrecoCompra).text.append(auxiliar.getString(3))
            findViewById<EditText>(R.id.campoPrecoVenda).text.append(auxiliar.getString(4))
        }
        bancoproduto.close()
    }
    fun voltar(view : View){
        val intent = Intent(this,
                PesquisarProdutosActivity::class.java)

        startActivity(intent)
        finish()
    }
}
