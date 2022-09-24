package com.example.howards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox

class OctavaPreguntaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_octava_pregunta)
    }

    fun novenaPregunta(view: View){
        val intent = Intent(this, NovenaPreguntaActivity::class.java).apply {
            val nombreUser = intent.getStringExtra("nombre")
            var contLuis = intent.getIntExtra("luis", LUIS_CONTADOR)
            var contElvira = intent.getIntExtra("elvira", ELVIRA_CONTADOR)
            var contCarlos = intent.getIntExtra("carlos", CARLOS_CONTADOR)
            var contRamon = intent.getIntExtra("ramon", RAMON_CONTADOR)
            putExtra("nombre", nombreUser)
            putExtra("luis", LUIS_CONTADOR)
            putExtra("elvira", ELVIRA_CONTADOR)
            putExtra("carlos", CARLOS_CONTADOR)
            putExtra("ramon", RAMON_CONTADOR)
        }

        val cb1 = findViewById<CheckBox>(R.id.checkBox1)
        val cb2 = findViewById<CheckBox>(R.id.checkBox2)
        val cb3 = findViewById<CheckBox>(R.id.checkBox3)
        val cb4 = findViewById<CheckBox>(R.id.checkBox4)

        if(cb1.isChecked)
            LUIS_CONTADOR++
        if(cb2.isChecked)
            RAMON_CONTADOR++
        if(cb3.isChecked)
            ELVIRA_CONTADOR++
        if(cb4.isChecked)
            CARLOS_CONTADOR++

        startActivity(intent)
    }
}