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
import com.example.tfbel.centraldaspecas.excluir.MenuExcluirActivity
import kotlinx.android.synthetic.main.activity_pesquisar_cliente_tela.*

class PesquisarClienteTela : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar_cliente_tela)
        supportActionBar?.hide()
        val intent = getIntent()
        val ID = intent.getIntExtra("ID", 0)
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

    fun voltar(view : View) {
        val intent = Intent(this,
                MenuPesquisarActivity::class.java)

        startActivity(intent)
        finish()
    }
}
