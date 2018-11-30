package com.example.tfbel.centraldaspecas.alterar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R
import com.example.tfbel.centraldaspecas.cadastrar.MenuCadastrarActivity

class AlterarClienteTela : AppCompatActivity() {

    var global = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar_cliente_tela)
        supportActionBar?.hide()
        val intent = getIntent()
        val ID = intent.getIntExtra("ID", 0)
        global = ID
        var bancocliente = openOrCreateDatabase("ClienteDB", Context.MODE_PRIVATE, null)

        val auxiliar = bancocliente.rawQuery("""SELECT *FROM ClienteDB WHERE campoIDCLiente = $ID
            """, null)

        if(auxiliar.moveToNext()){
            findViewById<EditText>(R.id.campoIDCliente).text.append(auxiliar.getInt(0).toString())
            findViewById<EditText>(R.id.campoNomeCliente).text.append(auxiliar.getString(1))
            findViewById<EditText>(R.id.campoDocumentoCliente).text.append(auxiliar.getString(2))
            findViewById<EditText>(R.id.campoEnderecoCliente).text.append(auxiliar.getString(3))
            findViewById<EditText>(R.id.campoNumEndCliente).text.append(auxiliar.getString(4))
            findViewById<EditText>(R.id.campoBairroCliente).text.append(auxiliar.getString(5))
            findViewById<EditText>(R.id.campoCidadeCliente).text.append(auxiliar.getString(6))
            findViewById<EditText>(R.id.campoUfCliente).text.append(auxiliar.getString(7))
            findViewById<EditText>(R.id.campoCepCliente).text.append(auxiliar.getString(8))
            findViewById<EditText>(R.id.campoTelefoneCliente).text.append(auxiliar.getString(9))
            findViewById<EditText>(R.id.campoEmailCliente).text.append(auxiliar.getString(10))
        }

        bancocliente.close()
    }

    fun alterar(botao: View){
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

        bancocliente.execSQL("""UPDATE ClienteDB
            SET campoNomeCliente = '$NomeCliente',
            campoDocumentoCliente = '$DocumentoCliente',
            campoEnderecoCliente = '$EnderecoCliente',
            campoNumEndCliente = '$NumeroEnderecoCliente',
            campoBairroCliente = '$BairroCliente',
            CampoCidadeCliente = '$CidadeCliente',
            campoUfCliente = '$UFCliente',
            campoCepCliente = '$CEPCliente',
            campoTelefoneCliente = '$TelefoneCliente',
            campoEmailCliente = '$EmailCliente'

            WHERE campoIDCliente = '$global'


            """)

        bancocliente.close()
        finish()
    }

    fun cancelar(view : View){
        val intent = Intent(this,
                AlterarClienteActivity::class.java)

        startActivity(intent)
        finish()
    }
}
