package com.example.wizardtrack.view.ui

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.wizardtrack.R
import com.example.wizardtrack.model.dto.SignUpServiceDTO
import com.example.wizardtrack.viewModel.CurrentSession
import com.example.wizardtrack.viewModel.SessionService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)
        val botonIniciarSesion = findViewById<Button>(R.id.btnEntrar)
        val serviceSession = SessionService()
        botonIniciarSesion.setOnClickListener {
            val email = findViewById<TextView>(R.id.txtEmail).text.toString()
            val name = findViewById<TextView>(R.id.txtName).text.toString()
            val password = findViewById<TextView>(R.id.TxtContrasena).text.toString()
            val scope = CoroutineScope(Dispatchers.IO)
            scope.launch {
                val response = serviceSession.signup(SignUpServiceDTO(name,email,password))
                if(response.id != 0.toLong() ){
                    //Sesion iniciada
                    mostrarAlertDialog(this@RegistroActivity, "Sesion iniciada")
                    CurrentSession.user = response
                    val intent = Intent(this@RegistroActivity, ContentActivity::class.java)
                    startActivity(intent)
                }else{
                    //Sesion NO iniciada, response.name
                    mostrarAlertDialog(this@RegistroActivity, "No se pudo iniciar sesion")
                    val intent = Intent(this@RegistroActivity, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
    fun mostrarAlertDialog(context: Context, mensaje: String) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(mensaje)

        // Crea y muestra el diálogo de alerta
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()

        // Configura un temporizador para cerrar el diálogo después de 2 segundos
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            alertDialog.dismiss()
        }, 2000)
    }
}
