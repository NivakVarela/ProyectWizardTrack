package com.example.wizardtrack.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.wizardtrack.R
import com.example.wizardtrack.viewModel.CurrentSession

class GastosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if(CurrentSession.user == null)
            this.onBackPressed()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gastos)

    }
    override fun onBackPressed() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
    fun cerrargastos(view: View) {
        val intent = Intent(this, ContentActivity::class.java)
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