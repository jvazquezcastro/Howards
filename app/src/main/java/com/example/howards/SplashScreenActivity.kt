package com.example.howards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import java.io.File
import java.util.TimerTask

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splasch_screen)

        startTimer()
    }

    fun startTimer() {
        object : CountDownTimer(5000, 1000) {

            override fun onTick(p0: Long) {

            }


            override fun onFinish() {
                val intent = Intent(applicationContext, UltimaPantallaActivity::class.java).apply {
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
                startActivity(intent)
            }
        }.start()
    }
}