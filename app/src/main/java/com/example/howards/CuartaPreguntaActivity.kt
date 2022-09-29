package com.example.howards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class CuartaPreguntaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuarta_pregunta_acitivity)

        val tercios = resources.getStringArray(R.array.Tercios)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tercios)
            spinner.adapter = adapter
        }
    }

    fun quintaPregunta(view: View) {

        val intent = Intent(this, QuintaPreguntaActivity::class.java).apply {

        }
        val spinner = findViewById<Spinner>(R.id.spinner)
        val index = spinner.selectedItemPosition

        if (index == 0)
            LUIS_CONTADOR++
        else if (index == 1)
            RAMON_CONTADOR++
        else if (index == 2)
            ELVIRA_CONTADOR++
        else
            CARLOS_CONTADOR++

        startActivity(intent)
    }
}