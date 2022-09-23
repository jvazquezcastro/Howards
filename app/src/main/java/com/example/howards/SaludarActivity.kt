package com.example.howards

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SaludarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludar)
        val nombreUser = intent.getStringExtra("nombre")
        val saludo = "Bienvenido $nombreUser.\n Vamos a ver con que profesor eres mas afín."
        val textSaludar = findViewById<TextView>(R.id.textSaludo).apply {
            text = saludo
        }
    }
    fun comenzarTest(view : View){
        val intent = Intent(this, PrimeraPreguntaActivity::class.java).apply {
            val nombreUser = intent.getStringExtra("nombre")
            var contLuis = intent.getIntExtra("luis", LUIS_CONTADOR)
            var contElvira = intent.getIntExtra("elvira", ELVIRA_CONTADOR)
            var contCarlos = intent.getIntExtra("carlos", CARLOS_CONTADOR)
            var contRamon = intent.getIntExtra("ramon", RAMON_CONTADOR)
            putExtra("nombre",nombreUser)
            putExtra("luis", LUIS_CONTADOR )
            putExtra("elvira", ELVIRA_CONTADOR )
            putExtra("carlos", CARLOS_CONTADOR )
            putExtra("ramon", RAMON_CONTADOR )
        }
        startActivity(intent)
    }

}