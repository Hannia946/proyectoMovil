package com.example.proyecto.cliente

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.Datos
import com.example.proyecto.R
import com.example.proyecto.databinding.ActivityDetalleEnvioBinding

class DetalleEnvioActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetalleEnvioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_envio)

        binding = ActivityDetalleEnvioBinding.inflate(layoutInflater)
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

        val nombreR = intent.getStringExtra("nombreRemitente")
        val apellidoR = intent.getStringExtra("apellidoRemitente")
        val nombreD = intent.getStringExtra("nombreDestinatario")
        val apellidoD = intent.getStringExtra("apellidoDestinatario")

        val descripcion = intent.getStringExtra("descripcion")
        val piezas = intent.getStringExtra("piezas")
        val peso = intent.getStringExtra("peso")
        val alto = intent.getStringExtra("alto")
        val ancho = intent.getStringExtra("ancho")
        val largo = intent.getStringExtra("largo")

        binding.etIdEnvio.setText(id)

        val calleRemitente = "${calle ?: ""} no.${no ?: ""}, ${colonia ?: ""}, ${estado ?: ""}"
        binding.etDireccionR.setText(calleRemitente)

        val calleDestinatario = "${calleD ?: ""} no.${noD ?: ""}, ${coloniaD ?: ""}, ${estadoD ?: ""}"
        binding.etDireccionD.setText(calleDestinatario)

        val nombreCompletoR = "${nombreR ?: ""} .${apellidoR ?: ""}"
        binding.etNombreR.setText(nombreCompletoR)

        val nombreCompletoD = "${nombreD ?: ""} .${apellidoD ?: ""}"
        binding.etNombreD.setText(nombreCompletoD)

        binding.etAlto.setText(alto)
        binding.etAncho.setText(ancho)
        binding.etLargo.setText(largo)

        binding.etQtyPzas.setText(piezas)
        binding.etPeso.setText(peso)
        binding.etDescipcion.setText(descripcion)



    }
}