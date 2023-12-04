package com.example.wizardtrack.view.ui

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.wizardtrack.R
import com.example.wizardtrack.viewModel.CurrentSession

class PerfilActivity : AppCompatActivity() {

    private lateinit var profileImage: ImageView
    private lateinit var uploadButton: Button
    private lateinit var usernameTextView: TextView

    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val imageUri = result.data?.data
                // Aquí deberías cargar la imagen seleccionada en tu ImageView
                profileImage.setImageURI(imageUri)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(CurrentSession.user == null)
            this.onBackPressed()
        setContentView(R.layout.perfil)

        profileImage = findViewById(R.id.profileImage)
        uploadButton = findViewById(R.id.uploadButton)
        usernameTextView = findViewById(R.id.usernameTextView)

        uploadButton.setOnClickListener {
            // Abre la galería para seleccionar una imagen
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            getContent.launch(intent)
        }
    }
    override fun onBackPressed() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun cerrarPerfil(view: View) {
        val intent = Intent(this, ContentActivity::class.java)
        startActivity(intent)
    }
}
