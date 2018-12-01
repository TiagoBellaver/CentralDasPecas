package com.example.tfbel.centraldaspecas.alterar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class AlterarFornecedorTela : AppCompatActivity() {

    var global = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar_fornecedor_tela)
        supportActionBar?.hide()

        val intent = getIntent()
        val ID = intent.getIntExtra("ID", 0)
        global = ID
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

    fun alterar(botao: View){
        var campoIdFornecedor = findViewById<EditText>(R.id.campoIDFornecedor)
        var campoNomeFornecedor = findViewById<EditText>(R.id.campoNomeFornecedor)
        var campoCNPJFornecedor = findViewById<EditText>(R.id.campoCnpjFornecedor)
        var campoEnderecoFornecedor = findViewById<EditText>(R.id.campoEnderecoFornecedor)
        var campoNumEndFornecedor = findViewById<EditText>(R.id.campoNumEndFornecedor)
        var campoBairroFornecedor = findViewById<EditText>(R.id.campoBairroFornecedor)
        var campoCidadeFornecedor = findViewById<EditText>(R.id.campoCidadeFornecedor)
        var campoUFFornecedor = findViewById<EditText>(R.id.campoUFFornecedor)
        var campoCepFornecedor = findViewById<EditText>(R.id.campoCepFornecedor)
        var campoTelefoneFornecedor = findViewById<EditText>(R.id.campoTelefoneFornecedor)
        var campoEmailFornecedor = findViewById<EditText>(R.id.campoEmailFornecedor)

        val NomeFornecedor = campoNomeFornecedor.text.toString()
        val CNPJFornecedor = campoCNPJFornecedor.text.toString()
        val EnderecoFornecedor = campoEnderecoFornecedor.text.toString()
        val NumEndFornecedor = campoNumEndFornecedor.text.toString()
        val BairroFornecedor = campoBairroFornecedor.text.toString()
        val CidadeFornecedor = campoCidadeFornecedor.text.toString()
        val UFFornecedor = campoUFFornecedor.text.toString()
        val CepFornecedor = campoCepFornecedor.text.toString()
        val TelefoneFornecedor = campoTelefoneFornecedor.text.toString()
        val EmailFornecedor = campoEmailFornecedor.text.toString()

        var bancofornecedor = openOrCreateDatabase("FornecedorDB", Context.MODE_PRIVATE,null)

        bancofornecedor.execSQL("""UPDATE FornecedorDB
            SET campoNomeFornecedor = '$NomeFornecedor',
            campoCNPJFornecedor = '$CNPJFornecedor',
            campoEnderecoFornecedor = '$EnderecoFornecedor',
            campoNumEndFornecedor = '$NumEndFornecedor',
            campoBairroFornecedor = '$BairroFornecedor',
            campoCidadeFornecedor = '$CidadeFornecedor',
            campoUFFornecedor = '$UFFornecedor',
            campoCepFornecedor = '$CepFornecedor',
            campoTelefoneFornecedor = '$TelefoneFornecedor',
            campoEmailFornecedor = '$EmailFornecedor'

            WHERE campoIDFornecedor = '$global'

              """)

        bancofornecedor.close()
        finish()
    }

    fun cancelar(view : View){
        val intent = Intent(this,
                AlterarFornecedorActivity::class.java)

        startActivity(intent)
        finish()
    }
}
