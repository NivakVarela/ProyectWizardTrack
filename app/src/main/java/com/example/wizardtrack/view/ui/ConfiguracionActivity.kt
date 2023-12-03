package com.example.wizardtrack.view.ui

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
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

class ConfiguracionActivity: AppCompatActivity() {

    private val CHANNEL_ID = "my_channel_id"
    private val notificationId = 101

    //LENGUAJE VARIABLE
    private lateinit var switch: Switch



    private lateinit var txtnot: Button
    private lateinit var txtnotificacion: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.configuracion)

        txtnot = findViewById(R.id.btnNotificacion)
        txtnotificacion = findViewById(R.id.notificacion)


        //LANG
        switch = findViewById(R.id.cambioIdioma)


        createNotificationChannel()

        txtnot.setOnClickListener()
        {
            sendNotification()
        }


        //lang

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "CHANGE TO ES", Toast.LENGTH_SHORT).show()
                actualizarResource("es")
            } else {
                Toast.makeText(this, "CAMBIO A EN", Toast.LENGTH_SHORT).show()
                actualizarResource("en")
            }
        }

    }


    //fun lang

    fun actualizarResource(idioma: String) {

        val recursos = resources
        val displayMetrics = recursos.displayMetrics
        val configuracion = resources.configuration
        configuracion.setLocale(Locale(idioma))
        recursos.updateConfiguration(configuracion, displayMetrics)
        configuracion.locale = Locale(idioma)
        resources.updateConfiguration(configuracion, displayMetrics)
        txtnot.text = recursos.getString(R.string.enviar)
        txtnotificacion.text = recursos.getString(R.string.notificacion)

    }


    private fun createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Title"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description=descriptionText
            }
            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(){
        val intent = Intent(this, ConfiguracionActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0,intent, PendingIntent.FLAG_IMMUTABLE)

        val bitmap = BitmapFactory.decodeResource(applicationContext.resources,
            R.drawable.logopng
        )
        val bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources,
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

        with(NotificationManagerCompat.from(this@ConfiguracionActivity))
        {
            if (ActivityCompat.checkSelfPermission(
                    this@ConfiguracionActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(notificationId, builder.build())
        }
    }


}







