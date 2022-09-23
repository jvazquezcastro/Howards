package com.example.howards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NovenaPreguntaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novena_pregunta)

        val aaa = findViewById<TextView>(R.id.aaa).apply{
            text = RAMON_CONTADOR.toString()
        }
    }
}