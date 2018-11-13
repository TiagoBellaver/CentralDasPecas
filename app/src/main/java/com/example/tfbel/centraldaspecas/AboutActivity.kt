package com.example.tfbel.centraldaspecas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.hide()

    }

    fun voltar(view : View) {
        val intent = Intent(this, HomeActivity::class.java)

        startActivity(intent)
        finish()
    }
}
