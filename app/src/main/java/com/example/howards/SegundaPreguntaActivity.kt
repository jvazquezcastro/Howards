package com.example.howards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SegundaPreguntaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pregunta)
        val nombreUser = intent.getStringExtra("nombre")
        var contLuis = intent.getIntExtra("luis", LUIS_CONTADOR)
        var contElvira = intent.getIntExtra("elvira", ELVIRA_CONTADOR)
        var contCarlos = intent.getIntExtra("carlos", CARLOS_CONTADOR)
        var contRamon = intent.getIntExtra("ramon", RAMON_CONTADOR)
        val resRamon = contRamon
        val textRes = findViewById<TextView>(R.id.textViewww).apply{
            text = resRamon.toString()
        }
    }
}