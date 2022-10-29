package com.example.howards

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

var arrUsuarios = ArrayList<String>()
var arrResultados = ArrayList<String>()
var arrFotos = ArrayList<Bitmap>()
var arrNombreFotos = ArrayList<String>()
///storage/emulated/0/Android/data/com.example.howards/files/Pictures
val directorioImg = "/storage/emulated/0/Android/data/com.example.howards/files/Pictures/"
class ResultadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)



        File(directorioImg).walkBottomUp().forEach {
                val foto = BitmapFactory.decodeFile(it.absolutePath);
                arrFotos.add(foto)
        }

        var rv: RecyclerView = findViewById(R.id.rv)

        val delim = ","
        val archivo = InputStreamReader(openFileInput("puntuaciones.csv"))
        val br = BufferedReader(archivo)
        var linea = br.readLine()
        while(linea != null){
            val arr = linea.split(delim).toTypedArray()
            arrUsuarios.add(arr[0])
            arrResultados.add(arr[1])
            arrNombreFotos.add(arr[2])
            linea = br.readLine()
        }
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        val mAdapter  = AdaptadorUsuarios()
        rv.adapter = mAdapter
    }

    class AdaptadorUsuarios : RecyclerView.Adapter<AdaptadorUsuarios.ViewHolder>() {

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.imprimir(position)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return ViewHolder(layoutInflater.inflate(R.layout.items_recycled, parent, false))
        }
        override fun getItemCount(): Int {
            return arrUsuarios.size
        }
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val usuario = view.findViewById(R.id.usuarioTextoItem) as TextView
            val resultado = view.findViewById(R.id.resultadoTextoItem) as TextView
            val avatar = view.findViewById<ImageView>(R.id.fotito)
            fun imprimir(posicion:Int){
                usuario.setText(arrUsuarios[posicion])
                resultado.setText(arrResultados[posicion])
                val ruta = "file:"+ directorioImg +arrNombreFotos[posicion]
                Picasso.with(avatar.context).load(ruta).fit().into(avatar)
                //avatar.setImageBitmap(arrFotos[posicion])
            }
        }
    }

}