package com.example.howards


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun comenzar(view: View){
        val intent = Intent(this, ComenzarActivity::class.java).apply {

        }
        startActivity(intent)
    }

    fun verResultados(view: View){
        val intent = Intent(this, ResultadosActivity::class.java).apply {

        }
        startActivity(intent)
    }
}