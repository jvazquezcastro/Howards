package com.example.howards

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.content.FileProvider.getUriForFile
import java.io.File
import java.io.IOException
import java.io.OutputStreamWriter
import java.text.SimpleDateFormat
import java.util.*

class CamaraActivity : AppCompatActivity() {
    private var uri: Uri? = null
    lateinit var currentPhotoPath: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hacerFoto()

    }

    fun hacerFoto() {

        val photoFile: File? = try {
            crearFicheroImagen()
        } catch (ex: IOException) {
            // Error occurred while creating the File
            ex.printStackTrace()
            null
        }
        if (photoFile != null) {
            uri = getUriForFile(
                this,
                "com.example.howards.fileprovider",
                photoFile
            )
            obtenerCamara.launch(uri)
        }
    }

    private fun crearFicheroImagen(): File {
        val nombre = intent.getStringExtra("nombre")
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "FNL_${nombre}_",
            ".jpg",
            storageDir /* directory */
        ).apply {
            currentPhotoPath = absolutePath
        }
    }
///storage/emulated/0/Android/data/com.example.howards/files/Pictures
    private val obtenerCamara=
        registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                Log.i(TAG, "Image Location :$uri")
                val archivo = OutputStreamWriter(openFileOutput("puntuaciones.csv", MODE_APPEND))
                val arr = uri.toString().split("/")
                val linea = arr[5]+"\n"
                archivo.write(linea);
                archivo.flush()
                val intent2 = Intent(this, SplashScreenActivity::class.java).apply {

                }
                startActivity(intent2)
            }
        }

}