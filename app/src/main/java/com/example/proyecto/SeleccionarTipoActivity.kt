package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.cliente.LoginClienteActivity
import com.example.proyecto.databinding.ActivitySeleccionarTipoBinding
import com.example.proyecto.Repartidor.LoginRepartidor
import com.example.proyecto.administrador.LoginAdministrador


class SeleccionarTipoActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySeleccionarTipoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeleccionarTipoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tipoCliente.setOnClickListener{
            startActivity(Intent(this@SeleccionarTipoActivity, LoginClienteActivity::class.java))
        }

        binding.tipoRepartidor.setOnClickListener{
            startActivity(Intent(this@SeleccionarTipoActivity, LoginRepartidor::class.java))
        }

        binding.tipoAdmin.setOnClickListener{
            startActivity(Intent(this@SeleccionarTipoActivity, LoginAdministrador::class.java))
        }
    }
}