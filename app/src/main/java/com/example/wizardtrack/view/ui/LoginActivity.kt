package com.example.wizardtrack.view.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.wizardtrack.R
import com.example.wizardtrack.model.dto.LoginServiceDTO
import com.example.wizardtrack.viewModel.CurrentSession
import com.example.wizardtrack.viewModel.SessionService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        if(CurrentSession.user != null)
            this.onBackPressed()

        val botonRegistro = findViewById<Button>(R.id.botonRegistro)
        val botonEntrar = findViewById<Button>(R.id.btnEntrar)
        val serviceSession = SessionService()
        val scope = CoroutineScope(Dispatchers.IO)
        botonEntrar.setOnClickListener {
            val email = findViewById<TextView>(R.id.txtEmail).text.toString()
            val password = findViewById<TextView>(R.id.TxtContrasena).text.toString()
            scope.launch {
                val response = serviceSession.login(LoginServiceDTO(email,password))
                if(response.id != 0.toLong() ){
                    //Si inicia sesion
                    CurrentSession.user = response
                    val intent = Intent(this@LoginActivity, ContentActivity::class.java)
                    startActivity(intent)
                }else{
                    //No inicio sesion
                }
            }

        }
        botonRegistro.setOnClickListener {
            Log.d("LoginActivity", "Clic en el botón de registro")
            val intent = Intent(this@LoginActivity, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        startActivity(Intent(this, ContentActivity::class.java))
    }
}
