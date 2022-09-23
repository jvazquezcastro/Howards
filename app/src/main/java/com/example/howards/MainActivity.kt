package com.example.howards


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

var LUIS_CONTADOR = 0
var ELVIRA_CONTADOR = 0
var CARLOS_CONTADOR = 0
var RAMON_CONTADOR = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun accederApp(view: View) {
        val campoUsuario = findViewById<EditText>(R.id.textAccess)
        val usuario = campoUsuario.text.toString()
        if (campoUsuario.text.isEmpty())
            showErrorMessage()
        else{
            val intent = Intent(this, SaludarActivity::class.java).apply {
                putExtra("nombre",usuario)
                putExtra("luis", LUIS_CONTADOR )
                putExtra("elvira", ELVIRA_CONTADOR )
                putExtra("carlos", CARLOS_CONTADOR )
                putExtra("ramon", RAMON_CONTADOR )
            }
            startActivity(intent)
        }
    }

    fun showErrorMessage() {
        Toast.makeText(this, "No has introducido ningun nombre", Toast.LENGTH_SHORT).show()
    }
}