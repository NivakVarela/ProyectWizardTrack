package com.example.wizardtrack.view.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.wizardtrack.R
import com.google.android.material.navigation.NavigationView

class contentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)

        // Referencia al DrawerLayout y NavigationView
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        val botonGasto = findViewById<Button>(R.id.btnGastos)
        val botonIngresos = findViewById<Button>(R.id.btnIngresos)


        //botones que redirigen
        botonGasto.setOnClickListener {
            Log.d("LoginActivity", "Clic en el botón de entrar")
            val intent = Intent(this@contentActivity, GastosActivity::class.java)
            startActivity(intent)
        }
        botonIngresos.setOnClickListener {
            Log.d("LoginActivity", "Clic en el botón de entrar")
            val intent = Intent(this@contentActivity, IngresosActivity::class.java)
            startActivity(intent)
        }

        // Configuración del listener para los elementos del menú
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Cerrar el drawer después de hacer clic en un elemento
            drawerLayout.closeDrawers()

            // Manejar la selección del menú
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, contentActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, PerfilActivity::class.java))
                    true
                }
                R.id.nav_subitem1 -> {
                    startActivity(Intent(this, IngresosActivity::class.java))
                    true
                }
                R.id.nav_subitem2 -> {
                    startActivity(Intent(this, GastosActivity::class.java))
                    true
                }
                R.id.nav_settings -> {
                    startActivity(Intent(this, ConfiguracionActivity::class.java))
                    true
                }
                R.id.nav_logout -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

}
