package com.example.wizardtrack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import com.example.wizardtrack.view.ui.PerfilActivity
import com.example.wizardtrack.view.ui.ConfiguracionActivity
import com.example.wizardtrack.view.ui.GastosActivity
import com.example.wizardtrack.view.ui.IngresosActivity

class contentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)

        // Referencia al DrawerLayout y NavigationView
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)

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
                    // Aquí puedes agregar el código para cerrar sesión si es necesario
                    true
                }
                else -> false
            }
        }
    }
}
