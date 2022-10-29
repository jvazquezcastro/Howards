package com.example.howards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import java.io.OutputStreamWriter

class DecimaPreguntaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decima_pregunta)
        guardarPuntuacion()
    }

    fun splashScreen(view: View){
        val grupoRadio = findViewById<RadioGroup>(R.id.grupoRadio)
        var id: Int = grupoRadio.checkedRadioButtonId
        if(id != -1){
            val intent = Intent(this, CamaraActivity::class.java).apply {
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
            val carlosChecked = findViewById<RadioButton>(R.id.respCarlos)
            val elviraChecked = findViewById<RadioButton>(R.id.respElvira)
            val luisChecked = findViewById<RadioButton>(R.id.respLuis)
            val ramonChecked = findViewById<RadioButton>(R.id.respRamon)
            if(carlosChecked.isChecked)
                CARLOS_CONTADOR ++
            else if(elviraChecked.isChecked)
                ELVIRA_CONTADOR ++
            else if(luisChecked.isChecked)
                LUIS_CONTADOR ++
            else
                RAMON_CONTADOR ++
            startActivity(intent)
        }else {
            Toast.makeText(this, "No has seleccionado ninguna opcion", Toast.LENGTH_SHORT).show()
        }
    }

    fun guardarPuntuacion() {
        val archivo = OutputStreamWriter(openFileOutput("puntuaciones.csv", MODE_APPEND))
        var puntos =
            arrayOf(RAMON_CONTADOR, LUIS_CONTADOR, ELVIRA_CONTADOR, CARLOS_CONTADOR).sorted()
        var nombPuntuacion = ""
        if(puntos[3] == RAMON_CONTADOR)
            nombPuntuacion = "Ramon"
        else if (puntos[3] == LUIS_CONTADOR)
            nombPuntuacion = "Luis"
        else if (puntos[3] == ELVIRA_CONTADOR)
            nombPuntuacion = "Elvira"
        else
            nombPuntuacion = "Carlos"
        val usuario = intent.getStringExtra("nombre")
        val linea = "$usuario,$nombPuntuacion,"
        archivo.write(linea);
        archivo.flush()
    }
}