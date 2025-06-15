package com.example.proyecto.cliente

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        binding.etIdEnvio.setText(id)

        val calleRemitente = "${calle ?: ""} no.${no ?: ""}, ${colonia ?: ""}, ${estado ?: ""}"
        binding.etDireccionR.setText(calleRemitente)

        val calleDestinatario = "${calleD ?: ""} no.${noD ?: ""}, ${coloniaD ?: ""}, ${estadoD ?: ""}"
        binding.etDireccionD.setText(calleDestinatario)

        //activa flecha pa ir atrás
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnCalificar.setOnClickListener{actualizarCalificacion()}



    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed() // Para API modernas
        return true
    }

    private fun actualizarCalificacion(){

    }
}