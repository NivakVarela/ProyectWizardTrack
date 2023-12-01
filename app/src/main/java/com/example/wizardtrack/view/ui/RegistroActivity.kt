package com.example.wizardtrack.view.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.wizardtrack.R

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        val botonIniciarSesion = findViewById<Button>(R.id.botonIniciarSesion)

        botonIniciarSesion.setOnClickListener {
            // Crear un Intent para abrir LoginActivity
            val intent = Intent(this@RegistroActivity, LoginActivity::class.java)

            // Iniciar la actividad de LoginActivity
            startActivity(intent)
        }
    }
}
