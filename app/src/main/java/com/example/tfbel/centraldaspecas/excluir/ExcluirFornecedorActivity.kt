package com.example.tfbel.centraldaspecas.excluir

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tfbel.centraldaspecas.HomeActivity
import com.example.tfbel.centraldaspecas.R

class ExcluirFornecedorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excluir_fornecedor)
        supportActionBar?.hide()
    }

    fun excluir(view: View){

        val auxiliar = findViewById<EditText>(R.id.campoExcluirFornecedor).text.toString().toInt()
        var bancofornecedor = openOrCreateDatabase("FornecedorDB", Context.MODE_PRIVATE, null)

        bancofornecedor.execSQL("""DELETE FROM FornecedorDB WHERE campoIDFornecedor = $auxiliar;
            """)

        bancofornecedor.close()


    }

    fun voltar(view : View) {
        val intent = Intent(this,
                MenuExcluirActivity::class.java)

        startActivity(intent)
        finish()
    }
}
