package com.example.tfbel.centraldaspecas.pesquisar

import android.content.Context
import android.content.Intent
import android.os.Build.ID
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R
import com.example.tfbel.centraldaspecas.cadastrar.CadastrarClienteActivity
import com.example.tfbel.centraldaspecas.cadastrar.MenuCadastrarActivity

class PesquisarClienteTela : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar_cliente_tela)
        supportActionBar?.hide()
        val intent = getIntent()
        val ID = intent.getIntExtra("ID", 0)
        var bancocliente = openOrCreateDatabase("ClienteDB", Context.MODE_PRIVATE, null)

        bancocliente.execSQL("""SELECT *FROM ClienteDB WHERE campoIDCLiente = $ID
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


        finish()
    }


}
