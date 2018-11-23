package com.example.tfbel.centraldaspecas.excluir

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class ExcluirProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excluir_produto)
        supportActionBar?.hide()

    }

    fun excluir(view: View){

        val auxiliar = findViewById<EditText>(R.id.campoExcluirProduto).text.toString().toInt()
        var bancoproduto = openOrCreateDatabase("ProdutoDB", Context.MODE_PRIVATE, null)

        bancoproduto.execSQL("""DELETE FROM ProdutoDB WHERE campoIDProduto = $auxiliar;
            """)

        bancoproduto.close()


    }

    fun voltar(view: View){
        val intent = Intent(this,
                MenuExcluirActivity::class.java)

        startActivity(intent)
    }
}
