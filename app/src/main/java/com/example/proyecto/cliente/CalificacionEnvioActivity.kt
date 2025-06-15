package com.example.proyecto.cliente

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.proyecto.Datos
import com.example.proyecto.R
import com.example.proyecto.databinding.ActivityCalificacionEnvioBinding

class CalificacionEnvioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalificacionEnvioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificacion_envio)

        binding = ActivityCalificacionEnvioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id")
        val calle = intent.getStringExtra("calle")
        val no = intent.getStringExtra("no")
        val colonia = intent.getStringExtra("colonia")
        val estado = intent.getStringExtra("estado")

        val calleD = intent.getStringExtra("calleD")
        val noD = intent.getStringExtra("noD")
        val coloniaD = intent.getStringExtra("coloniaD")
        val estadoD = intent.getStringExtra("estadoD")
        val comentario = intent.getStringExtra("comentarios")
        val calificacion = intent.getStringExtra("calificacion")


        binding.etIdEnvio.setText(id)

        val calleRemitente = "${calle ?: ""} no.${no ?: ""}, ${colonia ?: ""}, ${estado ?: ""}"
        binding.etDireccionR.setText(calleRemitente)

        val calleDestinatario = "${calleD ?: ""} no.${noD ?: ""}, ${coloniaD ?: ""}, ${estadoD ?: ""}"
        binding.etDireccionD.setText(calleDestinatario)

        binding.ratingBar.rating = calificacion?.toFloat() ?: 0f
        binding.ComentariosEnvio.setText(comentario ?: "")




        //activa flecha pa ir atrás
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnCalificar.setOnClickListener{actualizarCalificacion()}



    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed() // Para API modernas
        return true
    }

    private fun actualizarCalificacion(){
        val comentarios = binding.ComentariosEnvio.text.toString()
        val calificacion = binding.ratingBar.rating.toInt()

        val idEnvio = binding.etIdEnvio.text.toString().toIntOrNull()

        if (idEnvio != null) {
            Datos.calificarEnvio(idEnvio, calificacion, comentarios)

            AlertDialog.Builder(this)
                .setTitle("Calificación guardada")
                .setMessage("¡Gracias por su opinión!")
                .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
                .show()

            finish()
        } else {
            AlertDialog.Builder(this)
                .setTitle("ID inválido")
                .setMessage("ID de envío inválido")
                .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
                .show()
        }

    }
}