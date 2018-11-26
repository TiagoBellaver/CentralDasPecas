package com.example.tfbel.centraldaspecas.cadastrar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R
import kotlinx.android.synthetic.main.activity_cadastrar_fornecedor.*

class CadastrarFornecedorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_fornecedor)
        supportActionBar?.hide()

        var bancofornecedor = openOrCreateDatabase("FornecedorDB", Context.MODE_PRIVATE, null)

        bancofornecedor.execSQL("""CREATE TABLE IF NOT EXISTS FornecedorDB(
           campoIDFornecedor INTEGER PRIMARY KEY AUTOINCREMENT,
           campoNomeFornecedor VARCHAR(256),
           campoCNPJFornecedor VARCHAR(18),
           campoEnderecoFornecedor VARCHAR(256),
           campoNumEndFornecedor INTEGER,
           campoBairroFornecedor VARCHAR(50),
           campoCidadeFornecedor VARCHAR(50),
           campoUFFornecedor VARCHAR(2),
           campoCepFornecedor VARCHAR(9),
           campoTelefoneFornecedor VARCHAR(13),
           campoEmailFornecedor VARCHAR(50));
        """)

        bancofornecedor.close()
    }

    fun cadastrar(botao: View){
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

        bancofornecedor.execSQL("""INSERT INTO FornecedorDB('campoNomeFornecedor', 'campoCNPJFornecedor', 'campoEnderecoFornecedor',
             'campoNumEndFornecedor', 'campoBairroFornecedor', 'campoCidadeFornecedor', 'campoUFFornecedor',
             'campoCepFornecedor', 'campoTelefoneFornecedor', 'campoEmailFornecedor')
              VALUES ('$NomeFornecedor', '$CNPJFornecedor', '$EnderecoFornecedor', '$NumEndFornecedor', '$BairroFornecedor',
              '$CidadeFornecedor', '$UFFornecedor', '$CepFornecedor', '$TelefoneFornecedor', '$EmailFornecedor')
              """)
        bancofornecedor.close()
        finish()
    }

    fun criarfornecedor(view: View){
        val intent = Intent(this,
                CadastrarFornecedorActivity::class.java)

        startActivity(intent)
    }

    fun cancelar(view: View){
        val intent = Intent(this,
                MenuCadastrarActivity::class.java)

        startActivity(intent)
    }
}
