package com.example.howards


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun accederApp(view: View) {
        val btnAccess: Button = findViewById(R.id.btnAcceder)
        val textAccess: EditText = findViewById(R.id.textAccess)
        if (textAccess.text.isEmpty())
            showErrorMessage()
        else{
            val intent = Intent(this, TestActivity::class.java).apply{
            }
            startActivity(intent)
        }
    }

    fun showErrorMessage() {
        Toast.makeText(this, "No has introducido ningun nombre", Toast.LENGTH_SHORT).show()
    }
}