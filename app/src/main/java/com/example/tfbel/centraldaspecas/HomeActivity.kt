package com.example.tfbel.centraldaspecas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tfbel.centraldaspecas.alterar.MenuAlterarActivity
import com.example.tfbel.centraldaspecas.cadastrar.MenuCadastrarActivity
import com.example.tfbel.centraldaspecas.excluir.MenuExcluirActivity
import com.example.tfbel.centraldaspecas.pesquisar.MenuPesquisarActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

    }

    fun about(view : View) {
        val intent = Intent(this,
                AboutActivity::class.java)

        startActivity(intent)
    }

    fun menucadastro(view : View) {
        val intent = Intent(this,
                MenuCadastrarActivity::class.java)

        startActivity(intent)
    }

    fun menupesquisa(view : View) {
        val intent = Intent(this,
                MenuPesquisarActivity::class.java)

        startActivity(intent)
    }

    fun menualterar(view : View) {
        val intent = Intent(this,
                MenuAlterarActivity::class.java)

        startActivity(intent)
    }

    fun menuexcluir(view : View) {
        val intent = Intent(this,
                MenuExcluirActivity::class.java)

        startActivity(intent)
    }
}
