package com.example.tfbel.centraldaspecas.cadastrar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class CadastrarPedidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_pedido)
        supportActionBar?.hide()

        var bancopedido = openOrCreateDatabase("PedidoDB", Context.MODE_PRIVATE, null)

        bancopedido.execSQL("""CREATE TABLE IF NOT EXISTS PedidoDB(
            campoIDPedido INTEGER PRIMARY KEY AUTOINCREMENT,
            campoIDCliente INTEGER,
            campoIDPecaUm INTEGER,
            campoQtdPecaUm INTEGER,
            campoIDPecaDois INTEGER,
            campoQtdPecaDois INTEGER,
            campoIDPecaTres INTEGER,
            campoQtdPecaTres INTEGER,
            campoValorTotal VARCHAR(50));
            """)

        bancopedido.close()
    }

    fun cadastrar(botao: View){
        var campoIDPedido = findViewById<EditText>(R.id.campoIDPedido)
        var campoIDCliente = findViewById<EditText>(R.id.campoIDCliente)
        var campoIDPecaUm = findViewById<EditText>(R.id.campoIDPecaUm)
        var campoQtdPecaUm = findViewById<EditText>(R.id.campoQtdPecaUm)
        var campoIDPecaDois = findViewById<EditText>(R.id.campoIDPecaDois)
        var campoQtdPecaDois = findViewById<EditText>(R.id.campoQtdPecaDois)
        var campoIDPecaTres = findViewById<EditText>(R.id.campoIDPecaTres)
        var campoQtdPecaTres = findViewById<EditText>(R.id.campoQtdPecaTres)
        var campoValorTotal = findViewById<EditText>(R.id.campoValorTotal)

        val IDCliente = campoIDCliente.text.toString().toInt()
        val IDPecaUm = campoIDPecaUm.text.toString().toInt()
        val QtdPecaUm = campoQtdPecaUm.text.toString().toInt()
        val IDPecaDois = campoIDPecaDois.text.toString().toInt()
        val QtdPecaDois = campoQtdPecaDois.text.toString().toInt()
        val IDPecaTres = campoIDPecaTres.text.toString().toInt()
        val QtdPecaTres = campoQtdPecaTres.text.toString().toInt()
        val ValorTotal = campoValorTotal.text.toString()

        var bancopedido = openOrCreateDatabase("PedidoDB", Context.MODE_PRIVATE, null)

        bancopedido.execSQL("""INSERT INTO PedidoDB('campoIDCliente', 'campoIDPecaUm', 'campoQtdPecaUm',
            'campoIDPecaDois', 'campoQtdPecaDois', 'campoIDPecaTres', 'campoQtdPecaTres', 'campoValorTotal')
            VALUES ('$IDCliente', '$IDPecaUm', '$QtdPecaUm', '$IDPecaDois', '$QtdPecaDois', '$IDPecaTres'
             '$QtdPecaTres', '$ValorTotal')""")

        bancopedido.close()
        finish()
    }

    fun cancelar(view: View){
        val intent = Intent(this,
                MenuCadastrarActivity::class.java)

        startActivity(intent)
    }
}
