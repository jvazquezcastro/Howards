package com.example.howards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class UltimaPantallaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ultima_pantalla)
        calcularPuntos()
    }

    fun calcularPuntos() {
        val foto = findViewById<ImageView>(R.id.imageView)
        var puntos =
            arrayOf(RAMON_CONTADOR, LUIS_CONTADOR, ELVIRA_CONTADOR, CARLOS_CONTADOR).sorted()
        if (puntos[3] == RAMON_CONTADOR) {
            foto.setImageResource(R.drawable.po)
            val nombre = findViewById<TextView>(R.id.textResultado).apply {
                text = "Ramón"
            }
        } else if (puntos[3] == LUIS_CONTADOR) {
            foto.setImageResource(R.drawable.fredicksen)
            val nombre = findViewById<TextView>(R.id.textResultado).apply {
                text = "Luis"
            }
        } else if (puntos[3] == ELVIRA_CONTADOR) {
            foto.setImageResource(R.drawable.alaska)
            val nombre = findViewById<TextView>(R.id.textResultado).apply {
                text = "Elvira"
            }
        } else {
            foto.setImageResource(R.drawable.jesus)
            val nombre = findViewById<TextView>(R.id.textResultado).apply {
                text = "Carlos"
            }
        }

        //
        //
    }

    fun reiniciar(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply {
            RAMON_CONTADOR = 0
            CARLOS_CONTADOR = 0
            ELVIRA_CONTADOR = 0
            LUIS_CONTADOR = 0
        }
        startActivity(intent)
    }
}