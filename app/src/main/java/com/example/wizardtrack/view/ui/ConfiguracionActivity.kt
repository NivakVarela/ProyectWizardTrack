package com.example.wizardtrack.view.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.wizardtrack.R
import java.util.Locale

class ConfiguracionActivity : AppCompatActivity() {

    private val CHANNEL_ID = "my_channel_id"
    private val notificationId = 101

    // LEER EL IDIOMA DESDE LAS PREFERENCIAS
    private lateinit var sharedPreferences: SharedPreferences

    // LENGUAJE VARIABLE
    private lateinit var switch: Switch

    private lateinit var txtnot: Button
    private lateinit var txtnotificacion: TextView
    private lateinit var txtingreso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.configuracion)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        txtnot = findViewById(R.id.btnNotificacion)
        txtnotificacion = findViewById(R.id.notificacion)

        // LEER EL IDIOMA DESDE LAS PREFERENCIAS
        val idiomaActual = sharedPreferences.getString("idioma", "en")
        switch = findViewById(R.id.cambioIdioma)
        switch.isChecked = idiomaActual == "es"

        createNotificationChannel()

        txtnot.setOnClickListener {
            sendNotification()
        }

        switch.setOnCheckedChangeListener { _, isChecked ->
            val nuevoIdioma = if (isChecked) "es" else "en"
            cambiarIdioma(nuevoIdioma)

            // GUARDAR EL IDIOMA EN LAS PREFERENCIAS
            with(sharedPreferences.edit()) {
                putString("idioma", nuevoIdioma)
                apply()
            }

            // Reiniciar la actividad solo si el idioma cambió
            if (idiomaActual != nuevoIdioma) {
                restartActivity()
            }

            Toast.makeText(this, "Idioma cambiado a $nuevoIdioma", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cambiarIdioma(idioma: String) {
        val configuracion = resources.configuration
        val nuevaConfiguracion = Configuration(configuracion)
        nuevaConfiguracion.setLocale(Locale(idioma))
        baseContext.resources.updateConfiguration(
            nuevaConfiguracion,
            baseContext.resources.displayMetrics
        )
    }

    private fun restartActivity() {
        val intent = Intent(this, ConfiguracionActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Title"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {
        val intent = Intent(this, ConfiguracionActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val bitmap = BitmapFactory.decodeResource(
            applicationContext.resources,
            R.drawable.logopng
        )
        val bitmapLargeIcon = BitmapFactory.decodeResource(
            applicationContext.resources,
            R.drawable.logopng
        )

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(getString(R.string.Mensaje2))
            .setContentText(getString(R.string.Notificacion))
            .setLargeIcon(bitmapLargeIcon)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this@ConfiguracionActivity)) {
            if (ActivityCompat.checkSelfPermission(
                    this@ConfiguracionActivity,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(notificationId, builder.build())
        }
    }

    fun cerrarconfig(view: View) {
        val intent = Intent(this, contentActivity::class.java)
        startActivity(intent)
    }
}





