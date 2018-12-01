package com.example.tfbel.centraldaspecas.pesquisar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ViewAnimator
import com.example.tfbel.centraldaspecas.R

class PesquisarPedidoTela : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar_pedido_tela)
        supportActionBar?.hide()

        val intent = getIntent()
        val ID = intent.getIntExtra("ID", 0)
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
    fun voltar(view : View){
        val intent = Intent(this,
                PesquisarClienteActivity::class.java)

        startActivity(intent)
        finish()
    }
}
