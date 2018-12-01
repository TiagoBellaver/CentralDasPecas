package com.example.tfbel.centraldaspecas.cadastrar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class CadastrarClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_cliente)
        supportActionBar?.hide()

        var bancocliente = openOrCreateDatabase("ClienteDB", Context.MODE_PRIVATE, null)

        bancocliente.execSQL("""CREATE TABLE IF NOT EXISTS ClienteDB(
            campoIDCliente INTEGER PRIMARY KEY AUTOINCREMENT,
            campoNomeCliente VARCHAR(256),
            campoDocumentoCliente VARCHAR(18),
            campoEnderecoCliente VARCHAR(256),
            campoNumEndCliente INTEGER,
            campoBairroCliente VARCHAR(50),
            campoCidadeCliente VARCHAR(50),
            campoUfCliente VARCHAR(2),
            campoCepCliente VARCHAR(9),
            campoTelefoneCliente VARCHAR(13),
            campoEmailCliente VARCHAR(100));
            """)

        bancocliente.close()
    }

    fun cadastrar(botao: View){
        var campoIDCLiente = findViewById<EditText>(R.id.campoIDCliente)
        var campoNomeCliente = findViewById<EditText>(R.id.campoNomeCliente)
        var campoDocumentoCliente = findViewById<EditText>(R.id.campoDocumentoCliente)
        var campoEnderecoCliente = findViewById<EditText>(R.id.campoEnderecoCliente)
        var campoNumEndCliente = findViewById<EditText>(R.id.campoNumEndCliente)
        var campoBairroCliente = findViewById<EditText>(R.id.campoBairroCliente)
        var campoCidadeCliente = findViewById<EditText>(R.id.campoCidadeCliente)
        var campoUfCliente = findViewById<EditText>(R.id.campoUfCliente)
        var campoCepCliente = findViewById<EditText>(R.id.campoCepCliente)
        var campoTelefoneCliente = findViewById<EditText>(R.id.campoTelefoneCliente)
        var campoEmailCliente = findViewById<EditText>(R.id.campoEmailCliente)

        val NomeCliente = campoNomeCliente.text.toString()
        val DocumentoCliente = campoDocumentoCliente.text.toString()
        val EnderecoCliente = campoEnderecoCliente.text.toString()
        val NumeroEnderecoCliente = campoNumEndCliente.text.toString()
        val BairroCliente = campoBairroCliente.text.toString()
        val CidadeCliente = campoCidadeCliente.text.toString()
        val UFCliente = campoUfCliente.text.toString()
        val CEPCliente = campoCepCliente.text.toString()
        val TelefoneCliente = campoTelefoneCliente.text.toString()
        val EmailCliente = campoEmailCliente.text.toString()


        var bancocliente = openOrCreateDatabase("ClienteDB", Context.MODE_PRIVATE,null)

        bancocliente.execSQL("""INSERT INTO ClienteDB('campoNomeCliente', 'campoDocumentoCliente',
            'campoEnderecoCliente', 'campoNumEndCliente', 'campoBairroCliente', 'CampoCidadeCliente',
            'campoUfCliente', 'campoCepCliente', 'campoTelefoneCliente', 'campoEmailCliente')
            VALUES ('$NomeCliente', '$DocumentoCliente', '$EnderecoCliente', '$NumeroEnderecoCliente',
            '$BairroCliente', '$CidadeCliente', '$UFCliente', '$CEPCliente', '$TelefoneCliente', '$EmailCliente')
            """)

        bancocliente.close()
        finish()
    }

    fun cancelar(view: View){
        val intent = Intent(this,
                MenuCadastrarActivity::class.java)

        startActivity(intent)
        finish()
    }
}
