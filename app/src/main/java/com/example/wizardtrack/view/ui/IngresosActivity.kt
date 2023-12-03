package com.example.wizardtrack.view.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.wizardtrack.R
import com.example.wizardtrack.R.id.btnGastosIngresos
import com.example.wizardtrack.R.id.btnIngresosIngresos
import com.example.wizardtrack.viewModel.CurrentSession


class IngresosActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ingresos)
        if(CurrentSession.user == null)
            this.onBackPressed()
        val botonGastosclick= findViewById<Button>(btnGastosIngresos)
        val botonIngresosclick =findViewById<Button>(btnIngresosIngresos)

        botonGastosclick.setOnClickListener {
            Log.d("GastosActivity", "Clic en el botón de gastos")
            val intent = Intent(this@IngresosActivity, GastosActivity::class.java)
            startActivity(intent)
        }
        botonIngresosclick.setOnClickListener {
            Log.d("IngresosActivity", "Clic en el botón de ingresos")
            val intent = Intent(this@IngresosActivity, IngresosActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
    fun cerraringresos(view: View) {
        val intent = Intent(this, ContentActivity::class.java)
        startActivity(intent)
    }
}