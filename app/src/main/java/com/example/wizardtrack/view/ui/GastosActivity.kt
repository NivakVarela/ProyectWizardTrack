package com.example.wizardtrack.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.wizardtrack.R

class GastosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gastos)

    }
    fun cerrargastos(view: View) {
        val intent = Intent(this, contentActivity::class.java)
        startActivity(intent)
    }

    fun abrirgastos(view: View) {
        val intent = Intent(this, GastosActivity::class.java)
        startActivity(intent)
    }
    fun abriringresos(view: View) {
        val intent = Intent(this, IngresosActivity::class.java)
        startActivity(intent)
    }

}