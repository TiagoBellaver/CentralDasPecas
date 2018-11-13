package com.example.tfbel.centraldaspecas.cadastrar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tfbel.centraldaspecas.HomeActivity
import com.example.tfbel.centraldaspecas.R

class MenuCadastrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_cadastrar)
        supportActionBar?.hide()

    }

    fun cadastrarcliente(view: View){
        val intent = Intent(this,
                CadastrarClienteActivity::class.java)

        startActivity(intent)
    }

    fun voltar(view : View) {
        val intent = Intent(this,
                HomeActivity::class.java)

        startActivity(intent)
        finish()
    }
}
