package com.example.howards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PrimeraPreguntaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primera_pregunta)

        var contLuis = intent.getIntExtra("luis", LUIS_CONTADOR)
        var contElvira = intent.getIntExtra("elvira", ELVIRA_CONTADOR)
        var contCarlos = intent.getIntExtra("carlos", CARLOS_CONTADOR)
        var contRamon = intent.getIntExtra("ramon", RAMON_CONTADOR)
        LUIS_CONTADOR ++
        ELVIRA_CONTADOR ++
    }
}