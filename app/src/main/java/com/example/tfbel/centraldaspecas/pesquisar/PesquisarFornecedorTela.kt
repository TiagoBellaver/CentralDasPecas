package com.example.tfbel.centraldaspecas.pesquisar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class PesquisarFornecedorTela : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar_fornecedor_tela)
        supportActionBar?.hide()

        val intent = getIntent()
        val ID = intent.getIntExtra("ID", 0)
        var bancofornecedor = openOrCreateDatabase("FornecedorDB", Context.MODE_PRIVATE, null)

        var auxiliar = bancofornecedor.rawQuery("""SELECT *FROM FornecedorDB WHERE campoIDFornecedor = $ID""", null)

        if(auxiliar.moveToNext()){
            findViewById<EditText>(R.id.campoIDFornecedor).text.append(auxiliar.getInt(0).toString())
            findViewById<EditText>(R.id.campoNomeFornecedor).text.append(auxiliar.getString(1))
            findViewById<EditText>(R.id.campoCnpjFornecedor).text.append(auxiliar.getString(2))
            findViewById<EditText>(R.id.campoEnderecoFornecedor).text.append(auxiliar.getString(3))
            findViewById<EditText>(R.id.campoNumEndFornecedor).text.append(auxiliar.getString(4))
            findViewById<EditText>(R.id.campoBairroFornecedor).text.append(auxiliar.getString(5))
            findViewById<EditText>(R.id.campoCidadeFornecedor).text.append(auxiliar.getString(6))
            findViewById<EditText>(R.id.campoUFFornecedor).text.append(auxiliar.getString(7))
            findViewById<EditText>(R.id.campoCepFornecedor).text.append(auxiliar.getString(8))
            findViewById<EditText>(R.id.campoTelefoneFornecedor).text.append(auxiliar.getString(9))
            findViewById<EditText>(R.id.campoEmailFornecedor).text.append(auxiliar.getString(10))
        }

        bancofornecedor.close()
    }

    fun voltar(view : View){
        val intent = Intent(this,
                PesquisarFornecedorActivity::class.java)

        startActivity(intent)
        finish()
    }

}
