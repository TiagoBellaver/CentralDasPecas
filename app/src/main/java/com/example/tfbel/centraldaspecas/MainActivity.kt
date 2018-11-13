package com.example.tfbel.centraldaspecas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        var progresso = findViewById<ProgressBar>(
                        R.id.barraProgresso
                )

        Thread(Runnable {
            carregar(progresso)
        }).start()

    }

    fun carregar(barraProgresso : ProgressBar) {
        var progresso = 0

        while (progresso < 100) {
            try {
                Thread.sleep(30)
                barraProgresso.setProgress(progresso)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            progresso += 1
        }

        val intent = Intent(this,HomeActivity::class.java
        )
        startActivity(intent)
        finish()
    }
}
