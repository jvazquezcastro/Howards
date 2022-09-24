package com.example.howards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class UltimaPantallaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ultima_pantalla)
        calcularPuntos()
    }

    fun calcularPuntos() {
        val foto = findViewById<ImageView>(R.id.imageView)
        var puntos =
            arrayOf(RAMON_CONTADOR, LUIS_CONTADOR, ELVIRA_CONTADOR, CARLOS_CONTADOR).sorted()
        if (puntos[3] == RAMON_CONTADOR) {
            foto.setImageResource(R.drawable.po)
            val nombre = findViewById<TextView>(R.id.textResultado).apply {
                text = "Ramón"
            }
            val desc = findViewById<TextView>(R.id.textExplicacion).apply {
                text = "Todos te quieren, es imposible no hacerlo. Eres capaz de aprenderte el día anterior una lección y enseñarsela a un grupo de tontitos como si lo llevaras haciendo toda la vida. Tienes una risa particular y contagiosa. Eres capaz de ser el salvavidas de muchos por tu actitud de Teletubbie en este mundo lleno de perros salvajes. Imposible hacerte enfadar, ni siquiera borrándote un repositorio entero. Te gusta suspender a Daniel. Natalia va a interrumpirte en clase casi seguro. Una pena que tengas cara de morir pronto apuñalado por un alumno del Villablanca."
            }
        } else if (puntos[3] == LUIS_CONTADOR) {
            foto.setImageResource(R.drawable.fredicksen)
            val nombre = findViewById<TextView>(R.id.textResultado).apply {
                text = "Luis"
            }
            val desc = findViewById<TextView>(R.id.textExplicacion).apply {
                text = "Eres el terror de muchos, pero una vez que pasa el tiempo te conviertes en el salvador de la gente que te temía. Extremadamente legal, las normas están hechas para cumplirlas. Eres decidido y constante, a tí, si no te paran, tu sigues. A veces te surge algún problema y no duermes hasta darlo solucionado, aunque sean todos problemas de mentirijilla. No te gusta DAW, se te cae el pelo con ellos, mantente alejado. Tienes un extraño gusto con dejar a gente encerrada en lugares.  No te gustan ni los breaks ni la gente apellidada 'Jurado'. Bailas Swing como los ángeles."
            }
        } else if (puntos[3] == ELVIRA_CONTADOR) {
            foto.setImageResource(R.drawable.alaska)
            val nombre = findViewById<TextView>(R.id.textResultado).apply {
                text = "Elvira"
            }
            val desc = findViewById<TextView>(R.id.textExplicacion).apply {
                text = "La gente te adora. Tienes un gran sentido del humor y te gusta estar con gente con la que te diviertes, y se nota que lo haces ya que no todo el mundo tiene que ir a baño a limpiarse el rimmel por llorar de risa. Tienes alma de tutor/a, aunque no lo seas oficialmente, y harías lo que fuera para llevar a los interesados a estética. Te gusta disfrutar de las buenas cosas, como por ejemplo la cerveza (¿quién necesita abrebotellas pudiendo abrirla con el muslo?). Extraño fetiche con los XML. Todos te echarán de menos cuando te vayas, aunque a veces te sientas SOLA."
            }
        } else {
            foto.setImageResource(R.drawable.jesus)
            val nombre = findViewById<TextView>(R.id.textResultado).apply {
                text = "Carlos"
            }
            val desc = findViewById<TextView>(R.id.textExplicacion).apply {
                text = "Lo tienes todo medido y controlado, y es algo que dejas claro desde el primer momento. Eres capaz desde rastrear una IP de una conexión de un bunker siberiano hasta cazar gente infringiendo la ley cual halcón peregrino. Te gusta disfrutar de los placeres de la vida, y la cerveza es uno de ellos. Sientes mucha confianza en lo que haces y sabes que nadie puede sobrepasar esa seguridad.  Todos matarían por tus 100 puntos de EXP (menos Jesús). Te gusta hacer exámenes 'ligeritos' de 5 horas. Resumiendo: eres Jesucristo, eres Religión."
            }
        }

        //
        //
    }

    fun reiniciar(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply {
            RAMON_CONTADOR = 0
            CARLOS_CONTADOR = 0
            ELVIRA_CONTADOR = 0
            LUIS_CONTADOR = 0
        }
        startActivity(intent)
    }
}