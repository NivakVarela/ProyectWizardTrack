package com.example.wizardtrack.view.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import com.example.wizardtrack.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val botonRegistro = findViewById<Button>(R.id.botonRegistro)
        val botonEntrar = findViewById<Button>(R.id.btnEntrar)

        botonEntrar.setOnClickListener {
            Log.d("LoginActivity", "Clic en el botón de entrar")
            val intent = Intent(this@LoginActivity, contentActivity::class.java)
            startActivity(intent)
        }
        botonRegistro.setOnClickListener {
            Log.d("LoginActivity", "Clic en el botón de registro")
            val intent = Intent(this@LoginActivity, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}
