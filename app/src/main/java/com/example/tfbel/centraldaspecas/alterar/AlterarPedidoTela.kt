package com.example.tfbel.centraldaspecas.alterar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.R

class AlterarPedidoTela : AppCompatActivity() {

    var global = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar_pedido_tela)
        supportActionBar?.hide()

        val intent = getIntent()
        val ID = intent.getIntExtra("ID", 0)
        global = ID
        var bancopedido = openOrCreateDatabase("PedidoDB", Context.MODE_PRIVATE, null)

        val auxiliar = bancopedido.rawQuery("""SELECT *FROM PedidoDB WHERE campoIDPedido = $ID""", null)

        if(auxiliar.moveToNext()){
            findViewById<EditText>(R.id.campoIDPedido).text.append(auxiliar.getInt(0).toString())
            findViewById<EditText>(R.id.campoIDCliente).text.append(auxiliar.getInt(1).toString())
            findViewById<EditText>(R.id.campoIDPecaUm).text.append(auxiliar.getInt(2).toString())
            findViewById<EditText>(R.id.campoQtdPecaUm).text.append(auxiliar.getInt(3).toString())
            findViewById<EditText>(R.id.campoIDPecaDois).text.append(auxiliar.getInt(4).toString())
            findViewById<EditText>(R.id.campoQtdPecaDois).text.append(auxiliar.getInt(5).toString())
            findViewById<EditText>(R.id.campoIDPecaTres).text.append(auxiliar.getInt(6).toString())
            findViewById<EditText>(R.id.campoQtdPecaTres).text.append(auxiliar.getInt(7).toString())
            findViewById<EditText>(R.id.campoValorTotal).text.append(auxiliar.getString(8))
        }
        bancopedido.close()
    }

    fun alterar(botao: View){
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

        bancopedido.execSQL("""UPDATE PedidoDB
            SET campoIDCliente = '$IDCliente',
            campoIDPecaUm =  '$IDPecaUm',
            campoQtdPecaUm = '$QtdPecaUm',
            campoIDPecaDois =  '$IDPecaDois',
            campoQtdPecaDois = '$QtdPecaDois',
            campoIDPecaTres =  '$IDPecaTres',
            campoQtdPecaTres = '$QtdPecaTres',
            campoValorTotal = '$ValorTotal'

             WHERE campoIDPedido = '$global'
             """)

        bancopedido.close()
        finish()
    }

    fun cancelar(view : View){
        val intent = Intent(this,
                AlterarPedidoActivity::class.java)

        startActivity(intent)
        finish()
    }
}
